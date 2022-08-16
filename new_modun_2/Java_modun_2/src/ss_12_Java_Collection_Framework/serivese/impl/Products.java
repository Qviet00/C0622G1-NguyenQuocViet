package ss_12_Java_Collection_Framework.serivese.impl;

import ss_12_Java_Collection_Framework.serivese.IsProduct;
import ss_12_Java_Collection_Framework.Model.Product;

import java.util.LinkedList;
import java.util.Scanner;

public class Products implements IsProduct {
    private Scanner src = new Scanner(System.in);
    private static LinkedList<Product> products = new LinkedList<>();

    static {
        products.add(new Product(1, "A50", 12.000000, "Sam Sung"));
        products.add(new Product(2, "Not10", 10.000000, "Sam Sung"));
        products.add(new Product(3, "S22", 18.000000, "Sam Sung"));
        products.add(new Product(4, "S22Utral", 22.000000, "Sam Sung"));
    }


    @Override
    public void addProduct() {
        Product productsOne = this.infoProduct();
        products.add(productsOne);
        System.out.println("Add ok");
        for (Product pro : products
        ) {
            System.out.println(pro);
        }
    }

    @Override
    public void displayProduct() {
        for (Product pro : products
        ) {
            System.out.println(pro);
        }

    }

    @Override
    public void deleteProduct() {
        Product pro = this.findProduct();
        if (pro == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Delete ok  " + pro.getId());
            System.out.println("1 .OK");
            System.out.println("2 .Cancel");
            int choice = Integer.parseInt(src.nextLine());
            if (choice == 1) {
                products.remove(pro);
                System.out.println("Delete ok");
            }
            for (Product pros : products
            ) {
                System.out.println(pros);
            }
        }
    }

    @Override
    public void searchProduct() {
        Product pro = this.findProduct();
        if (pro == null) {
            System.out.println("Not found");
        } else {
            int choice = Integer.parseInt(src.nextLine());
            if (choice == 1) {
                System.out.println(pro);
                System.out.println("Search ok  " + pro.getId());
            }
        }
    }

    @Override
    public void editProduct() {

    }


    public Product findProduct() {
        System.out.print("Enter id perform: ");
        int id = Integer.parseInt(src.nextLine());
        for (Product pro : products) {
            if (pro.getId() == id) {
                return pro;
            }
        }
        return null;
    }

    public Product infoProduct() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(src.nextLine());
        System.out.print("Enter Name: ");
        String name = src.nextLine();
        System.out.print("Enter price: ");
        int price = Integer.parseInt(src.nextLine());
        System.out.print("Enter the Firm: ");
        String theFirm = src.nextLine();
        return new Product(id, name, price, theFirm);
    }
}

