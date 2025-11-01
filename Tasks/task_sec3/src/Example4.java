public class Example4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("Thread 1 Priority: " + Thread.currentThread().getPriority()));
        Thread t2 = new Thread(() -> System.out.println("Thread 2 Priority: " + Thread.currentThread().getPriority()));
        
        t1.setPriority(Thread.MIN_PRIORITY); 
        t2.setPriority(Thread.MAX_PRIORITY);
        
        t1.start();
        t2.start();
    }
}