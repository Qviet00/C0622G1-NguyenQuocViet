package ss_16_IO_Text_File.Post1;

import java.io.*;

public class CopyFileExample {
    public static void main(String[] args) throws IOException {
        InputStream textOne = null;
        OutputStream textTwo = null;
        try {
            textOne = new FileInputStream(new File("src/ss_16_IO_Text_File/Post1/text1"));
            textTwo = new FileOutputStream(new File("src/ss_16_IO_Text_File/Post1/text2"));

            int length;
            byte[] buffer = new byte[(8 * 1024)];
            while ((length = textOne.read(buffer)) > 0) {
                textTwo.write(buffer, 0, length);
            }
            System.out.println("Tiệp đã được sao chép.");
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            textOne.close();
            textTwo.close();
        }

    }
}
