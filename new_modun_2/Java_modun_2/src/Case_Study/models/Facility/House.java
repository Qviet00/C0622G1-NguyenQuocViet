package Case_Study.models.Facility;


public class House extends Facility {
    private String roomStandard;
    private int numberFloors;

    public House(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public House(String roomStandard, int numberFloors) {
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public House( String idService,String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType, String roomStandard, int numberFloors) {
        super(idService,serviceName,  usableArea, rentalCosts, peopleMax, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }


    @Override
    public String infoString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",this.getIdService(), this.getServiceName(),
                this.getUsableArea(), this.getRentalCosts(), this.getPeopleMax(), this.getRentalType(),
                getRoomStandard(), getNumberFloors());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",this.getIdService(), this.getServiceName(),
                this.getUsableArea(), this.getRentalCosts(), this.getPeopleMax(), this.getRentalType(),
                getRoomStandard(), getNumberFloors());
    }
}
