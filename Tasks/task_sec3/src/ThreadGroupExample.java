public class ThreadGroupExample {
    public static void main(String[] args) {
        
        ThreadGroup group = new ThreadGroup("My Group");
        
        Thread t1 = new Thread(group, () -> {
            System.out.println(Thread.currentThread().getName() + " in " + Thread.currentThread().getThreadGroup().getName());
        }, "Thread-1");
        
        Thread t2 = new Thread(group, () -> {
            System.out.println(Thread.currentThread().getName() + " in " + Thread.currentThread().getThreadGroup().getName());
        },"Thread-2");
        
        t1.start();
        t2.start();
    }
}