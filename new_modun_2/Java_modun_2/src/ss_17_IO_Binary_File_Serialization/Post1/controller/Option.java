package ss_17_IO_Binary_File_Serialization.Post1.controller;

import Case_Study.utils.Checked;
import ss_17_IO_Binary_File_Serialization.Post1.services.IsProduct;
import ss_17_IO_Binary_File_Serialization.Post1.services.impl.ProductServices;

import java.io.IOException;

public class Option {
    private IsProduct isProduct = new ProductServices();

    public void optionProduct() throws IOException {
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("BẢNG HIỆN THỊ LỰA CHỌN:");
            System.out.println("1. Display Product.");
            System.out.println("2. Add Product.");
            System.out.println("3. Search Product.");
            System.out.println("4. Exit.");
            System.out.print("Nhập lựa chọn: ");
            int value = 0;
            value = (int) Checked.checked(value,4);
            switch (value) {
                case 1: {
                    isProduct.disPlayProduct();
                }
                break;
                case 2: {
                    isProduct.addProduct();
                }
                break;
                case 3: {
                    isProduct.searchProduct();
                }
                break;
                case 4:
                    return;
            }
        }

    }
}


