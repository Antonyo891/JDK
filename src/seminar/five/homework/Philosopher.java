package seminar.five.homework;

import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private final CountDownLatch COUNT_DOWN_LATCH;
    private final CountDownLatch COUNT_DOWN_LATCH_SECOND;
    private static Integer countEating = 0;
    private final String NAME;
    private final Integer NUMBERS_OF_MEALS = 3;

    public Philosopher(String name, CountDownLatch countDownLatch,CountDownLatch countDownLatchSecond) {
        this.NAME = name;
        this.COUNT_DOWN_LATCH = countDownLatch;
        this.COUNT_DOWN_LATCH_SECOND = countDownLatchSecond;
    }

    @Override
    public void run() {
        try {
            COUNT_DOWN_LATCH.await();
        } catch (InterruptedException e) {
            System.out.println(" Philosopher" + NAME + "did not wait" + e.getMessage());;
        }
        int count = 0;
        while (count<NUMBERS_OF_MEALS){
            count++;
            eat(this);
            think();
        } COUNT_DOWN_LATCH_SECOND.countDown();

    }

    private static synchronized void eat(Philosopher philosopher){
        System.out.println("Philosopher " + philosopher.NAME + " are eating");
        try {
            Thread.sleep(1000);
            countEating++;
        } catch (InterruptedException e){
            System.out.println(philosopher.NAME + e.getMessage());
        }
    }
    private void think(){
        System.out.println("Philosopher " + NAME + " are thinking");
    }

    public static Integer getCountEating() {
        return countEating;
    }
}
