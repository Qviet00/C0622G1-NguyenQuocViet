package ss_16_IO_Text_File.Post3.controller;

import java.io.*;

public class ReadFileStudy1 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/ss_16_IO_Text_File/Post3/data/student");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            System.out.println(line);
        }
        bufferedReader.close();
    }
}