class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    public int getFixTime() {
        return 5; // Fix time for car
    }

    @Override
    public void fixed() {
        System.out.println("Car " + getName() + " has been fixed. All systems are operational!");
    }
}