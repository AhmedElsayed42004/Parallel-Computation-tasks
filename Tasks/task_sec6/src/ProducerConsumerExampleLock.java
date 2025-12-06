import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerExampleLock {
    static final int MAX_SIZE = 10;

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();

        Thread producerThread = new Thread(new Producer(queue, lock, notFull, notEmpty), "Producer");
        Thread consumerThread = new Thread(new Consumer(queue, lock, notFull, notEmpty), "Consumer");

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        private final Queue<String> queue;
        private final ReentrantLock lock;
        private final Condition notFull;
        private final Condition notEmpty;

        public Producer(Queue<String> queue, ReentrantLock lock, Condition notFull, Condition notEmpty) {
            this.queue = queue;
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
        }

        @Override
        public void run() {
            int count = 1;
            try {
                while (true) {
                    lock.lock();
                    try {
                        while (queue.size() == MAX_SIZE) {
                            System.out.println("Producer waiting, queue full");
                            notFull.await(); // الانتظار لو البافر مليان
                        }
                        String data = "Element-" + count++;
                        queue.add(data);
                        System.out.println("Produced: " + data + " | Queue size: " + queue.size());
                        notEmpty.signalAll(); // إخطار المستهلكين
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private final Queue<String> queue;
        private final ReentrantLock lock;
        private final Condition notFull;
        private final Condition notEmpty;

        public Consumer(Queue<String> queue, ReentrantLock lock, Condition notFull, Condition notEmpty) {
            this.queue = queue;
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();
                    try {
                        while (queue.isEmpty()) {
                            System.out.println("Consumer waiting, queue empty");
                            notEmpty.await(); // الانتظار لو البافر فاضي
                        }
                        String data = queue.poll();
                        System.out.println("Consumed: " + data + " | Queue size: " + queue.size());
                        notFull.signalAll(); // إخطار المنتجين
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
