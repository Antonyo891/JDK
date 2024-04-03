package developer;

public class Developers {
    public static void main(String[] args) {
        Developer developer = new Frontender();
        developer.getBackend();
        developer.getFrontend();
        Developer developer1 = new Backender();
        developer1.getFrontend();
        developer1.getBackend();
        Developer developer2 = new FullStack();
        developer2.getBackend();
        developer2.getFrontend();

    }
}
