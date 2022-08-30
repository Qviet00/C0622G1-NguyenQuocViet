package ss_17_IO_Binary_File_Serialization.Post1.services.impl;

import Case_Study.utils.Checked;
import ss_17_IO_Binary_File_Serialization.Post1.model.Product;
import ss_17_IO_Binary_File_Serialization.Post1.services.IsProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServices implements IsProduct {
    public static final String path = "src/ss_17_IO_Binary_File_Serialization/Post1/data/textProduct.csv";
    private static Scanner src = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();

    @Override
    public void disPlayProduct() {
        products = readDataFromFile(path);
        for (Product pr : products) {
            System.out.println(pr);
        }
    }

    @Override
    public void addProduct() throws IOException {
        products = readDataFromFile(path);
        Product product = this.infoProduct();
        products.add(product);
        writeToFile(path, products);
        System.out.println("Thêm thành công.");
    }

    @Override
    public void searchProduct() {
        Product product = this.findProduct();
        products.add(product);
        for (Product pr : products
        ) if (pr==null){
            System.out.println("Không tìm thấy id.");
        }else
            System.out.println(pr);
        }

    public static void writeToFile(String path, List<Product> products) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public Product findProduct() {
        products = readDataFromFile(path);
        System.out.print("Mời bạn nhập vào id tìm: ");
        int id = 0;
        id = Checked.checkedOne(id,0);
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product infoProduct() {
        System.out.print("Mời bạn nhập mã sản phẩm: ");
        int id = Integer.parseInt(src.nextLine());
        System.out.print("Mời bạn nhập tên sản phẩm: ");
        String name = src.nextLine();
        System.out.print("Mời bạn nhập hãng sản xuất: ");
        String firm = src.nextLine();
        System.out.print("Mời bạn giá: ");
        double money = Double.parseDouble(src.nextLine());
        return new Product(id, name, firm, money);
    }
}
