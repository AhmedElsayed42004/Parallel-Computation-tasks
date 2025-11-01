

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread daemon = new Thread(() -> {
            try {
                while (true){
                    System.out.println("Daemon thread running: " + Thread.currentThread().getName());
                    Thread.sleep(500);
                }
            }catch (InterruptedException e){
                System.out.println("Deamon interrupted");
            }
        },"MyDaemonThread");
        daemon.setDaemon(true);
        daemon.start();
        
        System.out.println("Main thread ends: " + Thread.currentThread().getName());
    }
}