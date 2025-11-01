class WorkerThread extends Thread {
    @Override
    public void run(){
        System.out.println("Thread started:" + getName());
        int x = 10 / 0;
    }
}

public class UncaughtHandlerExample {
    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread();
        
        t1.setUncaughtExceptionHandler((thread, exception) -> {
            System.out.println(" Exception in " + thread.getName()+ " : " + exception.getMessage());
        });
        
        t1.start();
    }
}