public class Thread1 extends Thread {
    //creating thread by extending thread class
    //this is the child thread(user) of the main thread

    public Thread1(String name){
        super(name);
    }
    @Override
    public void run() {
        for(int i = 0 ; i < 10; i++){
            System.out.println("Inside Thread1 " + Thread1.currentThread() );
        }
    }
}
