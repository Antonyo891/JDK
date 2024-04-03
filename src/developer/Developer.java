package developer;

public abstract class Developer implements Backend, Frontend {
    static int count;
    String name;

    public Developer(String name) {
        this.name = name;
    }

}
