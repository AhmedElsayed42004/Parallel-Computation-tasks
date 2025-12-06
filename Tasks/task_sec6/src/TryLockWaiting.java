import java.util.concurrent.locks.ReentrantLock;

public class TryLockWaiting {
    private final ReentrantLock lock = new ReentrantLock();

    void attemptLock() {
        if (lock.tryLock()) { 
            try {
                System.out.println("Got the lock!");
            } finally {
                lock.unlock(); 
            }
        } else {
            System.out.println("Could not get the lock, will try later");
        }
    }

    public static void main(String[] args) {
        TryLockWaiting example = new TryLockWaiting();
        example.attemptLock();
    }
}
