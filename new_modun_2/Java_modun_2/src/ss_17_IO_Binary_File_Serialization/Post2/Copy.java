package ss_17_IO_Binary_File_Serialization.Post2;

import ss_17_IO_Binary_File_Serialization.Post1.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Copy {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/ss_17_IO_Binary_File_Serialization/text1.vsc");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new Student(1, "Văn Nam", "C0622G1"));
        objectOutputStream.close();
        InputStream text1 = null;
        OutputStream text2 = null;

        try {
            text1 = new FileInputStream(new File("src/ss_17_IO_Binary_File_Serialization/text1.vsc"));
            text2 = new FileOutputStream(new File("src/ss_17_IO_Binary_File_Serialization/text2.vsc"));

            int length;
            byte[] arr = new byte[8 * 1024];
            while ((length = text1.read(arr)) > 0) {
                text2.write(arr, 0, length);
            }
            System.out.println("File đã được copy");
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            text1.close();
            text2.close();
        }
        FileInputStream fileInputStream = new FileInputStream("src/ss_17_IO_Binary_File_Serialization/text1.vsc");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        long size = fileInputStream.getChannel().size();
        System.out.println(objectInputStream.readObject());
        System.out.println("File có độ dài " + size + " byte");
        objectInputStream.close();
    }
    public static List<Product> readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }
}
