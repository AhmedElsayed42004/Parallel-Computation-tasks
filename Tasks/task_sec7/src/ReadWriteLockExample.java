import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    void readData() {
        readLock.lock();
        try {
            System.out.println("Reading data");
        } finally {
            readLock.unlock();
        }
    }

    void writeData() {
        writeLock.lock();
        try {
            System.out.println("Writing data");
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample example = new ReadWriteLockExample();
        example.readData();
        example.writeData();
    }
}
