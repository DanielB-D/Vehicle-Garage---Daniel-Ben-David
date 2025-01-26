import java.util.Scanner;

class MainScreen implements ProtocolGarage {
    private DB db;
    private Garage garage;

    public MainScreen() {
        db = new DB();
        garage = new Garage(this);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vehicles you want to add:");

        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter 1 for Motorcycle, 2 for Car, 3 for Truck:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter the vehicle's name:");
            String name = scanner.nextLine();

            Vehicle vehicle;
            if (choice == 1) {
                vehicle = new Motorcycle(name);
            } else if (choice == 2) {
                vehicle = new Car(name);
            } else if (choice == 3) {
                vehicle = new Truck(name);
            } else {
                System.out.println("Invalid choice! Skipping...");
                continue;
            }

            db.addVehicle(vehicle);
        }

        System.out.println("Sending vehicles to the garage...");
        garage.addVehicles(db.getVehicles());

        while (true) {
            garage.tick();
            if (garage.getVehicles().size() == garage.getCurrentIndex()) {
                break;
            }
        }
    }

    @Override
    public void fixed(Vehicle vehicle) {
        System.out.println("MainScreen: Vehicle " + vehicle.getName() + " has been fixed!");
    }
}
