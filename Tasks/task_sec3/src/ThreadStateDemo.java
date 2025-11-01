public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("State inside run(): " + Thread.currentThread().getState());
        });
        
        System.out.println("Before start(): " + t1.getState());
        
        t1.start();
        System.out.println("After start(): " + t1.getState());
        
        t1.join();
        
        System.out.println("After completion: " + t1.getState());
    }
}