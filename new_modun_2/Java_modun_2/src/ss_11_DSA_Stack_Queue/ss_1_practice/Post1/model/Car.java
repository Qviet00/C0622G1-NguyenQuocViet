package ss_11_DSA_Stack_Queue.ss_1_practice.Post1.model;

public class Car extends ManageVehicle {
    private int seat;
    private String shape;

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Car(int seat, String shape) {
        this.seat = seat;
        this.shape = shape;
    }

    public Car(String licensePlate, String nameCompany, int yearManufacture, String owner, int seat, String shape) {
        super(licensePlate, nameCompany, yearManufacture, owner);
        this.seat = seat;
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seat=" + seat +
                ", shape='" + shape + '\'' +
                "} " + super.toString();
    }
}
