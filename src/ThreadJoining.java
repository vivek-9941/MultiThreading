public class ThreadJoining {
    public static void main(String[] args) {
        System.out.println("main started");
            Thread thread= new Thread( () ->{
                System.out.println(Thread.currentThread());

            });
            thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //thread.join forces the currently executing thread to wait until  the specified thread completes the execution
        System.out.println("main ended");

        //get the priority  of the thead
        System.out.println( "priority of  another user  thread "  +thread.getPriority());
        System.out.println( "priority of  main  thread "  +Thread.currentThread().getPriority());
    }

}

//output
//before join method
//main started
//main ended
//Thread[#30,Thread-0,5,main]

//after join method
