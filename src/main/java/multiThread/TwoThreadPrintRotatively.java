package multiThread;

public class TwoThreadPrintRotatively {
    public static void main(String[] args) {
        Template template = new Template();
        new Thread(() ->{
            try {
                template.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->{
            try {
                template.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
class Template{
    int num = 0;
    int limit = 100;
    public synchronized void print() throws InterruptedException {
        while (num < limit){
            System.out.println(Thread.currentThread().getName() + " " + num++);
            notifyAll();
            wait(1000);
        }

    }
}