import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class Lock {
    
    public void lock() {
        System.out.println("Lock acquired");
    }
   
    public void unlock() {
        System.out.println("Lock released");
    }
    
    public boolean tryLock() {
        System.out.println("Trying to acquire lock");
        return true;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        System.out.println("Trying to acquire lock with timeout");
        return true;
    }

    public void lockInterruptibly() throws InterruptedException {
        System.out.println("Lock interruptibly");
    }

    public Condition newCondition() {
        return null; // مثال بسيط
    }

    public static void main(String[] args) {
        Lock lock = new Lock();
        lock.lock();
        lock.unlock();
    }
}
