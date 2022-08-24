package Case_Study.models;

public class RentalContract extends Booking {
    private String numberContracts;
    private double depositInAdvance;
    private double paymentTotal;

    public RentalContract() {
    }

    public RentalContract(String numberContracts, double depositInAdvance, double paymentTotal) {
        this.numberContracts = numberContracts;
        this.depositInAdvance = depositInAdvance;
        this.paymentTotal = paymentTotal;
    }

    public RentalContract(String id, String codeBooking, String numberContracts, double depositInAdvance, double paymentTotal) {
        super(id, codeBooking);
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
        return String.format("%s,%s,%s,%s,%s", this.getId(), this.getCodeBooking(), getNumberContracts(),
                getDepositInAdvance(), getPaymentTotal());
    }
}
