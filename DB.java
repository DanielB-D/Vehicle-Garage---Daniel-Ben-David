import java.util.*;

class DB {
    private ArrayList<Vehicle> vehicles;

    public DB() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
