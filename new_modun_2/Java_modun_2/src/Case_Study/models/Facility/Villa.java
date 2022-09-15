package Case_Study.models.Facility;


public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int numberFloors;

    public Villa() {
    }



    public Villa(String idService,String serviceName, double usableArea, double rentalCosts, int peopleMax, String rentalType,
                 String roomStandard, double poolArea, int numberFloors) {
        super(idService,serviceName, usableArea, rentalCosts, peopleMax, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }
    @Override
    public String infoString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",this.getIdService(), this.getServiceName(),
                this.getUsableArea(), this.getRentalCosts(), this.getPeopleMax(), this.getRentalType(),
                getRoomStandard(), getPoolArea(), getNumberFloors());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",this.getIdService(), this.getServiceName(),
                this.getUsableArea(), this.getRentalCosts(), this.getPeopleMax(), this.getRentalType(),
                getRoomStandard(), getPoolArea(), getNumberFloors());
    }
}
