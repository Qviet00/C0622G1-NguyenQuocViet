package Case_Study.models;

public class Home extends Facility{
    private String  serviceFree;

    public Home() {
    }

    public Home(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    public Home(String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType,
                String serviceFree) {
        super(serviceName, usableArea, rentalCosts, peopleMax, rentalType);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getServiceName(),
                this.getUsableArea(), this.getRentalCosts(), this.getPeopleMax(), this.getRentalType(),getServiceFree());
    }
}
