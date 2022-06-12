package multiThread;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        producer.start();
        consumer.start();

    }


}

class Producer extends Thread {
    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int i = 1;
        while (true){
            try {
                sleep(10);
                buffer.add(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(20);
                buffer.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Buffer{
    Deque<Integer> buffer = new ArrayDeque<>();
    int capacity = 20;
    public synchronized void add(int num) throws InterruptedException {
        //这里为什么要用while而不是if 如果同时两个线程进入了等待, 一个线程等待结束被notify了
        //往队列里加了数, 另一个线程如果不再一次进行判断的话, 也会出来往队列里加数据, 此时就
        //超过了capacity
        while(buffer.size() > capacity){
            this.wait();
        }
        buffer.addLast(num);
        System.out.println("Producer add " + num);
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while(buffer.isEmpty()) wait();
        notifyAll();
        System.out.println("Consumer get " + buffer.getFirst());
        return buffer.removeFirst();
    }
}
