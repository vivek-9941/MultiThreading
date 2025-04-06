import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("starting main");
        Thread thread1 = new Thread1("myThread1");
//        thread1.setDaemon(true); if you wish to make this thread as daemon
        thread1.start();//this will not immediately start or execute. i depends on jvm when it is free
        //once it is free it will execute the run method in the Thread1

//        Thread thread2 = new Thread(new Thread2());
        //the same thing can be done in
        Thread thread2 = new Thread(() -> {
            //copy of run  in Thread2
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + " , " + i);
            }
        });
        thread2.start();
        System.out.println("ending main");
        //note that if  depends on the jvm how to execute threads it is not the case that you will get output executed in same order always


        //synchronisation
        MyStack stack = new MyStack(5);

        new Thread(() -> {
            int counter = 0;
            while (++counter < 10)
                stack.push(100);
        }, "Pusher").start();

        new Thread(() -> {
            int counter = 0;
            while (++counter < 10)
                stack.pop();
        }, "Popper").start();

        System.out.println("main is exiting");


    }
}