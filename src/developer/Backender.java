package developer;

public class Backender extends Developer implements Backend,Frontend {


    public Backender(String name) {
        super(name);
    }
    public Backender(){
        this("Backender_"+count++);
    }

    @Override
    public void getBackend() {
        System.out.println(name + " completed");
    }

    @Override
    public void getFrontend() {

        System.out.println(name + " note done");
    }
}
