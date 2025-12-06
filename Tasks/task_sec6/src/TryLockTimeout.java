import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTimeout {
    private final ReentrantLock lock = new ReentrantLock();

    void attemptLockWithTimeout() {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println("Got the lock within 2 seconds");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Timeout after 2 seconds");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }
    }

    public static void main(String[] args) {
        TryLockTimeout example = new TryLockTimeout();
        example.attemptLockWithTimeout();
    }
}
