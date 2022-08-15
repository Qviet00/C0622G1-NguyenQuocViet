package ss_11_DSA_Stack_Queue.ss_1_practice.Post1.model;

public class Truck extends ManageVehicle {
    private int tonnage;

    public Truck() {
    }

    public Truck(int tonnage) {
        this.tonnage = tonnage;
    }

    public Truck(String licensePlate, String nameCompany, int yearManufacture, String owner, int tonnage) {
        super(licensePlate, nameCompany, yearManufacture, owner);
        this.tonnage = tonnage;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "tonnage=" + tonnage +
                "} " + super.toString();
    }
}
