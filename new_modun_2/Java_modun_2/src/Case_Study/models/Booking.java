package Case_Study.models;

public  class Booking{
    private String codeBooking;
    private String startDate;
    private String endDate;
    private String codeId;
    private String serviceName;
    private String typeService;

    public Booking(String idEmployee, String name, String dateOfBirth, String grand, String numberCard, String numberPhone, String email, String level, String location, String salary) {
    }

    public Booking(String codeBooking, String startDate, String endDate, String codeId,String serviceName, String typeService) {
        this.codeBooking = codeBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.codeId =codeId;
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

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
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
        return String.format("%s,%s,%s,%s,%s,%s", getCodeBooking(), getStartDate(),
                getEndDate(),getCodeId(), getServiceName(), getTypeService());
    }
}
