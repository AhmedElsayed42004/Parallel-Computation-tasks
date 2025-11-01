public class Example1 {
    public static void main(String[] args) {
        Thread t1 = new Thread("MyFirstThread");
        t1.start();
        System.out.println("Thread Name: " + t1.getName());
    }
}