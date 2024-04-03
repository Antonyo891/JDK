package developer;

public class Frontender extends Developer implements Backend,Frontend {


    public Frontender(String name) {
        super(name);
    }
    public Frontender(){
        this("Frontender_"+count++);
    }

    @Override
    public void getBackend() {
        System.out.println(name + " Note done");
    }

    @Override
    public void getFrontend() {
        System.out.println(name + " Completed");
    }
}
