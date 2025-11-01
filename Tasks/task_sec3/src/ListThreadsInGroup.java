

public class ListThreadsInGroup{
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("Workers");
        
        Thread t1 = new Thread(group, ()-> System.out.println("Running: " + Thread.currentThread().getName()),"Worker-1");
        Thread t2 = new Thread(group, ()-> System.out.println("Running: " + Thread.currentThread().getName()), "Worker-2");
        
        t1.start();
        t2.start();
        
        Thread.sleep(100);
        
        System.out.println("Active Threads in Group: " + group.activeCount());
        group.list();
    }
}