package multiThread;

import static java.lang.Thread.sleep;

public class Multi2 {
    public static void main(String[] args) {
        // extemd thread class就可以直接start
        new Thread2().start();
        // 实现runable 接口还需要放入Thread实例中才能start
        new Thread(new Thread3()).start();
        // lambda
        new Thread(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("This is thread 1......");
            }
        }).start();

    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This is thread 2....");
        }
    }
}

class Thread3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This is thread 3");
        }
    }
}
