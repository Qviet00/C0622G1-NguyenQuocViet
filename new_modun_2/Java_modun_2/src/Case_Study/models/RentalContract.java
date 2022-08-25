package Case_Study.models;

public class RentalContract {
    private String idBooking;
    private String codeContract;
    private String numberContracts;
    private double depositInAdvance;
    private double paymentTotal;

    public RentalContract() {
    }

    public RentalContract(String idBooking, String codeContract, String numberContracts, double depositInAdvance, double paymentTotal) {
        this.idBooking = idBooking;
        this.codeContract = codeContract;
        this.numberContracts = numberContracts;
        this.depositInAdvance = depositInAdvance;
        this.paymentTotal = paymentTotal;
    }

    public String getNumberContracts() {
        return numberContracts;
    }

    public void setNumberContracts(String numberContracts) {
        this.numberContracts = numberContracts;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getCodeContract() {
        return codeContract;
    }

    public void setCodeContract(String codeContract) {
        this.codeContract = codeContract;
    }

    public double getDepositInAdvance() {
        return depositInAdvance;
    }

    public void setDepositInAdvance(double depositInAdvance) {
        this.depositInAdvance = depositInAdvance;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", getNumberContracts(), getCodeContract(), getNumberContracts(),
                getDepositInAdvance(), getPaymentTotal());
    }
}
