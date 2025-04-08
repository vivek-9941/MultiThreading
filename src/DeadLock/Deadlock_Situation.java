package DeadLock;
//question is create an deadlock situation
public class Deadlock_Situation {

    public static void main(String[] args) {

    String lock1 = "bmwm340li";
    String lock2  ="bmwm760li";
    Thread thread1 = new Thread(()->{
        synchronized (lock1) {
            try {
                Thread.sleep(1);
                synchronized (lock2) {
                    System.out.println("Lock acquired");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });

    Thread thread2 = new Thread(()->{
        synchronized (lock2) {
            try {
                Thread.sleep(1);
                synchronized (lock1) {
                    System.out.println("Lock acquired");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });
 thread1.start();
thread2.start();
    }
}
