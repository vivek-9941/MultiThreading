public class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + " , " + i);
        }
    }
}
//. Java doesn't support multiple inheritance of classes
//If you extend Thread, you can’t extend any other class, because:

//class MyTask extends Thread {
//    // Now you cannot extend any other class
//}
//So you're locked in — and that limits flexibility.
//
// 🔄 But if you implement Runnable, you’re free to extend any class:

//class MyTask extends SomeOtherClass implements Runnable {
//    public void run() {
//        // thread logic here
//    }
//}
//✅ More flexible and object-oriented.
