package multiThread;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProducerAndConsumer2 {
    public static void main(String[] args) {
        Buffer2 buffer = new Buffer2(2);

        new Thread(() -> {

            while (true){
                try {
                    int i = 0;
                    buffer.add(i++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "producer 1").start();





        new Thread(() -> {

            while (true){
                try {
                    buffer.poll();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }


}

class Buffer2{
    Deque<Integer> buffer = new ArrayDeque<>();
    int size;
    public Buffer2(int size){
        this.size = size;
    }
    public synchronized void add(int num) throws InterruptedException {
        while(buffer.size() > size){
            wait();
        }
        buffer.addLast(num);
        System.out.println("producer adds " + num);
        notify();
    }

    public synchronized void poll() throws InterruptedException {
        while(buffer.size() == 0){
            wait();
        }
        Integer num = buffer.removeLast();
        System.out.println("consumer gets " + num);
        notify();
    }
}