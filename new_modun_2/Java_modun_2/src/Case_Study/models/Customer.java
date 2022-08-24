package Case_Study.models;

public abstract class Customer extends ManagementSystem {
    private String typeGuest;
    private String address;

    public Customer() {
    }

    public Customer(String typeGuest) {
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public Customer(String id, String name, String birthDay, String grand, double numberCard,
                    String numberPhone, String email, String typeGuest, String address) {
        super(id, name, birthDay, grand, numberCard, numberPhone, email);
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public String getTypeGuest() {
        return typeGuest;
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
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getId(), this.getName(),
                this.getBirthDay(), this.getGrand(), this.getNumberCard(), this.getNumberPhone(),
                this.getEmail(), getTypeGuest(), getAddress());
    }
}
