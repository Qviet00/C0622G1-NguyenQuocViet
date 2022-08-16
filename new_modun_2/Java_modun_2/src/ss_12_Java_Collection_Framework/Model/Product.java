package ss_12_Java_Collection_Framework.Model;



public class Product{
    private  int id;
    private String name;
    private double price;
    private String theFirm;

    public Product() {
    }

    public Product(int id, String name, double price, String theFirm) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.theFirm = theFirm;
    }

    public Product(int id, String name, int price, String theFirm) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.theFirm = theFirm;
    }

    public  int getId() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTheFirm() {
        return theFirm;
    }

    public void setTheFirm(String theFirm) {
        this.theFirm = theFirm;
    }

    @Override
    public String toString() {
        return String.format("{ Id: %d, Name: %s, Price: %.6f vnd, The Fimr: %s}",getId(),getName(),getPrice(),getTheFirm());
    }

}

