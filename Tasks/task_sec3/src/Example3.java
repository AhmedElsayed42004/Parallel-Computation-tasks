public class Example3 {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Running in: " + Thread.currentThread().getName());
        Thread t3 = new Thread(task, "RunnableThread");
        t3.start();
    }
}