abstract class Vehicle implements Fixable {
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getFixTime();

    @Override
    public abstract void fixed();
}