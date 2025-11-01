public class Example2 {
    public static void main(String[] args) {
        Thread t2 = new Thread();
        t2.setName("WorkerThread-1");
        t2.start();
        System.out.println("Thread Name: " + t2.getName());
    }
}