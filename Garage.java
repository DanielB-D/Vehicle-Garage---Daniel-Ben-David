import java.util.*;

class Garage {
    private ProtocolGarage protocol;
    private ArrayList<Vehicle> vehicles;
    private int currentIndex;

    public Garage(ProtocolGarage protocol) {
        this.protocol = protocol;
        this.vehicles = new ArrayList<>();
        this.currentIndex = 0;
    }

    public void addVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles.addAll(vehicles);
    }

    public void tick() {
        if (currentIndex < vehicles.size()) {
            Vehicle currentVehicle = vehicles.get(currentIndex);
            int fixTime = currentVehicle.getFixTime();

            try {
                System.out.println("Fixing " + currentVehicle.getName() + "...");
                Thread.sleep(fixTime * 1000);
                currentVehicle.fixed();
                protocol.fixed(currentVehicle);
                currentIndex++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("All vehicles have been fixed!");
        }
    }

    // Add these two methods:
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}
