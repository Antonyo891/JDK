package generelization.person;

import generelization.person.Person;

public class Worker implements Person {
    static int number = 0;
    String name = "Worker";

    public Worker() {
        this.name += number++;
    }
    @Override
    public Boolean doWork() {
        System.out.println("With pleasure");
        return true;
    }

    @Override
    public Boolean haveRest() {
        System.out.println("I have a lot of work to doWorker");
        return false;
    }
}
