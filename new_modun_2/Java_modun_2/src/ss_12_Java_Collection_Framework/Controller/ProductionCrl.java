package ss_12_Java_Collection_Framework.Controller;

import ss_12_Java_Collection_Framework.serivese.IsProduct;
import ss_12_Java_Collection_Framework.serivese.impl.Products;

import java.util.Scanner;

public class ProductionCrl {
    private static final Scanner src = new Scanner(System.in);
    IsProduct isProduct = new Products();

    public void optionProduct() {
        while (true) {
            System.out.println("Hello");
            System.out.println("---------------------------------------------");
            System.out.println("1.Display ");
            System.out.println("2. Add ");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Edit");
            System.out.println("6. Cancel");
            System.out.print("Import 1->6: ");
            int choice1 = Integer.parseInt(src.nextLine());
            switch (choice1) {
                case 1:
                    isProduct.displayProduct();
                    break;
                case 2:
                    isProduct.addProduct();
                    break;
                case 3:
                    isProduct.deleteProduct();
                    break;
                case 4:
                    isProduct.searchProduct();
                    break;
                case 5:
                    isProduct.editProduct();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong");
            }

        }
    }
}
