package Case_Study.models.Managerment;

public class Employee extends ManagementSystem {
    private String idEmployee;
    private String level;
    private String location;
    private String salary;

    public Employee(String s, String name, String dateOfBirth, String grand, String numberCard, String numberPhone, String email, String typeGuest, String address) {
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Employee(String idEmployee, String level, String location, String salary) {
        this.idEmployee = idEmployee;
        this.level = level;
        this.location = location;
        this.salary = salary;
    }

    public Employee(String idEmployee, String name, String birthDay, String grand, String numberCard,
                    String numberPhone, String email, String level, String location, String salary) {
        super(name, birthDay, grand, numberCard, numberPhone, email);
        this.idEmployee =idEmployee;
        this.level = level;
        this.location = location;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String infoString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", getIdEmployee(), this.getName(),
                this.getBirthDay(), this.getGrand(), this.getNumberCard(), this.getNumberPhone(), this.getEmail(), getLevel(),
                getLocation(), getSalary());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", getIdEmployee(), this.getName(),
                this.getBirthDay(), this.getGrand(), this.getNumberCard(), this.getNumberPhone(), this.getEmail(), getLevel(),
                getLocation(), getSalary());
    }
}
