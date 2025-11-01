public class MainExample2 {
    public static void main(String[] args) {
        Runnable task = new MyTask();
        Thread t = new Thread(task);
        t.start();
    }
}