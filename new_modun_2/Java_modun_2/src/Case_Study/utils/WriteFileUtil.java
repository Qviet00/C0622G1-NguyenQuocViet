package Case_Study.utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileUtil {
    private static void writeFile(String path, String data)  {
        try{
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeEmployee(String path,boolean t, List<String> convertListEmployeeToListString) {
        StringBuilder data = new StringBuilder();
        for (String em : convertListEmployeeToListString) {
            data.append(em);
        }
        writeFile(path, data.toString());
    }
}
