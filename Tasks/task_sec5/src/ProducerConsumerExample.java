import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    static final int MAX_SIZE = 10;

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
                          
        Thread producerThread = new Thread(new Producer(queue), "Producer");
        Thread consumerThread = new Thread(new Consumer(queue), "Consumer");

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        private final Queue<String> queue;

        public Producer(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int count = 1;
            try {
                while (true) {
                    produceData("Element-" + count++);
                    Thread.sleep(1000); 
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void produceData(String data) throws InterruptedException {
            synchronized (queue) {
                while (queue.size() == MAX_SIZE) {
                    System.out.println("Producer waiting, queue full");
                    queue.wait();
                }
                queue.add(data);
                System.out.println("Produced: " + data + " | Queue size: " + queue.size());
                queue.notifyAll();
            }
        }
    }

    static class Consumer implements Runnable {
        private final Queue<String> queue;

        public Consumer(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    consumeData();
                    Thread.sleep(1000); 
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void consumeData() throws InterruptedException {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Consumer waiting, queue empty");
                    queue.wait();
                }
                String data = queue.poll();
                System.out.println("Consumed: " + data + " | Queue size: " + queue.size());
                queue.notifyAll(); 
            }
        }
    }
}
