package Case_Study.models;

public abstract class Booking extends Customer {
    private String codeBooking;
    private String startDate;
    private String endDate;
    private String serviceName;
    private String typeService;

    public Booking() {
    }

    public Booking(String codeBooking, String startDate) {
        this.codeBooking = codeBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.serviceName = serviceName;
        this.typeService = typeService;
    }

    public Booking(String id, String codeBooking, String startDate, String endDate, String serviceName, String typeService) {
        super(id);
        this.codeBooking = codeBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.serviceName = serviceName;
        this.typeService = typeService;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getId(), getCodeBooking(), getStartDate(),
                getEndDate(), getServiceName(), getTypeService());
    }
}
