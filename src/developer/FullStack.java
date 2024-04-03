package developer;

public class FullStack extends Developer implements Backend,Frontend {


    public FullStack(String name) {
        super(name);
    }
    public FullStack(){
        this("FullStack_"+count++);
    }

    @Override
    public void getBackend() {
        System.out.println(name + " Completed");
    }

    @Override
    public void getFrontend() {
        System.out.println(name + " Completed");
    }
}
