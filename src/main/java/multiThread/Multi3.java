package multiThread;

public class Multi3 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 =  new Thread(() -> {
            for(int i = 0; i < 300; i++){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket.buy();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 200; i++){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket.buy();
            }
        });

        Thread t3 = new Thread(() -> {
            for(int i = 0; i < 500; i++){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket.buy();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("剩余票数为 " + ticket.tickets);

    }
}

class Ticket{
    int tickets = 1000;
    public void buy(){
        tickets = tickets - 1;
    }
}
