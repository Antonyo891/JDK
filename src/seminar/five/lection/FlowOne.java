package seminar.five.lection;

public class FlowOne implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getClass().getSimpleName());
        int i =100;
        while (i-->1){
            try {
                Thread.sleep(300);
                System.out.println("i = " + i);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

        }
        System.out.println("Good bay from flow" + this.getClass().getSimpleName());
    }
}
