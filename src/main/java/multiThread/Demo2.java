package multiThread;
class Eat implements Runnable {

    @Override
    public void run() {
        while (true)
        System.out.println("Eat ....");
    }
}

class Jump implements Runnable {
    @Override
    public void run(){
        while(true)
        System.out.println("Jump.....");
    }
}

public class Demo2 {


    public static void main(String[] args) {
        Eat eat = new Eat();
        Jump jump = new Jump();
        Thread thread1 = new Thread(eat);
        Thread thread2 = new Thread(jump);

        thread1.start();
        thread2.start();
    }
}
