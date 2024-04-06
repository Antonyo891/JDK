package generelization.person;

import generelization.person.Person;

public class Slacker implements Person {
    static int number = 0;
    String name = "Slacker";

    public Slacker() {
        this.name += number++;
    }

    @Override
    public Boolean doWork() {
        System.out.println("I have not rested yet");
        return false;
    }

    @Override
    public Boolean haveRest() {
        System.out.println("With pleasure.Z-z-z-z.");
        return true;
    }
}
