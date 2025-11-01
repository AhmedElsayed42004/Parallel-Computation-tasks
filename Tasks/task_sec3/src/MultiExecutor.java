import java.util.*;

public class MultiExecutor {

    public static void main(String[] args) {

        List<Thread> list = new ArrayList<>();

        Runnable th1 = () -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        };

        Runnable th2 = () -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        };

        Runnable th3 = () -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(th1, "Thread1");
        thread1.setPriority(4);

        Thread thread2 = new Thread(th2, "Thread2");
        thread2.setPriority(7);

        Thread thread3 = new Thread(th3, "Thread3");
        thread3.setPriority(1);

        list.add(thread1);
        list.add(thread2);
        list.add(thread3);

        ThreadManagement threadManagement = new ThreadManagement(list);
        threadManagement.executeAll();
    }

    static class ThreadManagement {

        List<Thread> list;

        public void executeAll() {
            for (Thread thread : list) {
                thread.start();
            }
        }

        ThreadManagement(List<Thread> list) {
            this.list = list;
        }
    }
}