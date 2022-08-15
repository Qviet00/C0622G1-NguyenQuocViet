package ss_11_DSA_Stack_Queue.ss_1_practice.Post1.model;

public abstract class ManageVehicle {
    private static String licensePlate;
    private String nameCompany;
    private int yearManufacture;
    private String owner;

    protected ManageVehicle() {
    }

    public ManageVehicle(String licensePlate, String nameCompany, int yearManufacture, String owner) {
        this.licensePlate = licensePlate;
        this.nameCompany = nameCompany;
        this.yearManufacture = yearManufacture;
        this.owner = owner;
    }

    public  String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        ManageVehicle.licensePlate = licensePlate;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "ManageVehicle{" +
                "bienKiemSoat='" + licensePlate + '\'' +
                ", tenHangSanXuat='" + nameCompany + '\'' +
                ", namSanXuat=" + yearManufacture +
                ", chuSoHuu='" + owner + '\'' +
                '}';
    }
}

