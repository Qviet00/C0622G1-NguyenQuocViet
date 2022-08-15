package ss_11_DSA_Stack_Queue.ss_1_practice.Post1.model;

public class Motorcycle extends ManageVehicle {
    private int wattage;

    public Motorcycle() {
    }

    public Motorcycle(int wattage) {
        this.wattage = wattage;
    }

    public Motorcycle(String licensePlate, String nameCompany, int yearManufacture, String owner, int wattage) {
        super(licensePlate, nameCompany, yearManufacture, owner);
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "wattage=" + wattage +
                "} " + super.toString();
    }
}
