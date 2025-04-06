public class Synchronous {

}


//without using synchronise threads work asynchronously as per jvm task scheduler
//Exception in thread "Pusher" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5
//	at MyStack.push(Synchronous.java:32)
class MyStack {
    private int[] stack;
    private int top;
    private int capacity;
    Object lock;

    public MyStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
        lock = new Object();
    }


    public void push(int value) {
        synchronized (lock) {//can pass any object


            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;

            }
            top++;
//        Only one thread can access a synchronized method of the same stack object at a time.
//        It locks the stack object.
//        No other thread can enter any other synchronized method on that same stack object until the first thread exits.
            try {
                Thread.sleep(1000);
                //when two threads work parallely it will interfere each other
//            which will lead to stack underflow or overflow
//            sleep() just tells the current thread to pause — it doesn’t force the other thread to run immediately.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stack[top] = value;
        }
    }

    public int pop() {
        synchronized (lock) {
            //lock is like a key taken by a thread from jvm
            //Only one thread can hold the monitor (lock) on this specific object at any moment
            //If Thread A is executing push() and is inside synchronized(lock)
            //Thread B that tries to execute pop() will be blocked at synchronized(lock) until Thread A releases the lock.
            //to run different threads on differnt synchoronise ,pass different objs insteadd of one lock but it will again work async

            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int obj = stack[top];
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            top--;

            return obj;
        }
    }
//    public synchronized int pop() { can be use
//    }
    // in this case there is no explicit lock
    //synchronize can  be used only if you want to synchronize some block
    //for whole method use above given method
    //internally it uses lock as "this" as object and wrap whole code of the function

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
