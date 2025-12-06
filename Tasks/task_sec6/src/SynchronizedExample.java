public class SynchronizedExample {
    private final Object monitor = new Object();
    
    public void criticalSection(){
        synchronized (monitor) {
            System.out.println("Executing Critical Section");
        }
    }

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();
        example.criticalSection();
    }
}
