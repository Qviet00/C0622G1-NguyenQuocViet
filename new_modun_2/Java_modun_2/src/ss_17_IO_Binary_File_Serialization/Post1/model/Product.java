package ss_17_IO_Binary_File_Serialization.Post1.model;

public class Product implements java.io.Serializable{
    private int id;
    private String name;
    private String theFirm;
    private double price;

    public Product() {
    }

    public Product(int id, String name, String theFirm, double price) {
        this.id = id;
        this.name = name;
        this.theFirm = theFirm;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheFirm() {
        return theFirm;
    }

    public void setTheFirm(String theFirm) {
        this.theFirm = theFirm;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",getId(),getName(),getTheFirm(),getPrice());
    }
}
