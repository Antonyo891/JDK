package seminar.five.lection;

import static java.lang.Thread.sleep;

public class SeminarFiveMain {
    private static class ExampleThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println(this.getClass().getSimpleName());
            int count = 0;
            boolean exit = this.isInterrupted();
            System.out.println(exit);
            while (!exit){
                try {
                    sleep(100);
                    System.out.print(this.isInterrupted());
                    System.out.println(" " + count++);
                    if (count==100) break;;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("GoodBuy");
        }
    }
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        FlowOne flowOne = new FlowOne();
        Thread threadOne = new Thread(flowOne);
        threadOne.start();
        ExampleThread exampleThread = new ExampleThread();
        exampleThread.start();

        try {
            sleep(100);
            threadOne.interrupt();
            while (!threadOne.isInterrupted())                    {
                threadOne.interrupt();

            }
            System.out.println(threadOne.isInterrupted());
            while (!exampleThread.isInterrupted()){
                exampleThread.interrupt();
            }
            System.out.println(exampleThread.isInterrupted());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
