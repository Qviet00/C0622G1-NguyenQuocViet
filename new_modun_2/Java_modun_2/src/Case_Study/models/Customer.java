package Case_Study.models;

public class Customer extends ManagementSystem {
    private String idCustomer;
    private String typeGuest;
    private String address;

    public Customer() {
    }

    public Customer(String id, String typeGuest, String address) {
        this.idCustomer = id ;
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public Customer(String id, String name, String birthDay, String grand, double numberCard,
                    String numberPhone, String email, String typeGuest, String address) {
        super(name, birthDay, grand, numberCard, numberPhone, email);
        this.idCustomer =id;
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
