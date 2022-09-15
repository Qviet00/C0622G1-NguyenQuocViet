package Case_Study.models.Managerment;

public class Customer extends ManagementSystem {
    private String idCustomer;
    private String typeGuest;
    private String address;

    public Customer() {
    }

    @Override
    public String infoString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", getIdCustomer(), this.getName(),
                this.getBirthDay(), this.getGrand(), this.getNumberCard(), this.getNumberPhone(),
                this.getEmail(), getTypeGuest(), getAddress());
    }

    public Customer(String idCustomer, String typeGuest, String address) {
        this.idCustomer = idCustomer ;
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public Customer(String idCustomer, String name, String birthDay, String grand, String numberCard,
                    String numberPhone, String email, String typeGuest, String address) {
        super(name, birthDay, grand, numberCard, numberPhone, email);
        this.idCustomer =idCustomer;
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public String getTypeGuest() {
        return typeGuest;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setTypeGuest(String typeGuest) {
        this.typeGuest = typeGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", getIdCustomer(), this.getName(),
                this.getBirthDay(), this.getGrand(), this.getNumberCard(), this.getNumberPhone(),
                this.getEmail(), getTypeGuest(), getAddress());
    }
}
