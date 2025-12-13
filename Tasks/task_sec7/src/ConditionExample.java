import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {

    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Queue<Integer> queue = new LinkedList<>();

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Queue empty, waiting...");
                notEmpty.await();
            }
            int item = queue.remove();
            System.out.println("Consumed: " + item);
        } finally {
            lock.unlock();
        }
    }

    public void produce(int item) {
        lock.lock();
        try {
            queue.add(item);
            System.out.println("Produced: " + item);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ConditionExample example = new ConditionExample();

        Thread consumer = new Thread(() -> {
            try {
                example.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(2000); 
                example.produce(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        producer.start();
    }
}
