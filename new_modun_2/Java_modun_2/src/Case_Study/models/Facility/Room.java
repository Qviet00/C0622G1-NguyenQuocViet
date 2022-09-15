package Case_Study.models.Facility;

public class Room extends Facility {
    private String  serviceFree;

    public Room() {
    }



    public Room( String idService,String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType, String serviceFree) {
        super( idService,serviceName, usableArea, rentalCosts, peopleMax, rentalType);
        this.serviceFree = serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }
    @Override
    public String infoString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",this.getIdService(), this.getServiceName(),
                this.getUsableArea(), this.getRentalCosts(), this.getPeopleMax(), this.getRentalType(),getServiceFree());
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",this.getIdService(), this.getServiceName(),
                this.getUsableArea(), this.getRentalCosts(), this.getPeopleMax(), this.getRentalType(),getServiceFree());
    }
}
