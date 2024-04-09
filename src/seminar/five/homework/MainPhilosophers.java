package seminar.five.homework;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class MainPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        CountDownLatch latch1 = new CountDownLatch(5);
        ArrayList<Thread> philosophers= new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            philosophers.add(new Philosopher(("Philosopher_" + (i + 1)),latch,latch1));
            philosophers.get(i).start();
            latch.countDown();
        }
        latch1.await();
        System.out.println(Philosopher.getCountEating());
    }
}
