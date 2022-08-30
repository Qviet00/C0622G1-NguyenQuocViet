package Case_Study.utils;

import Case_Study.models.Facility.Facility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WriteFacility {
    public static void writeFacility(String path, Map<Facility, Integer> facilities, boolean i) {
        List<String> stringList = new ArrayList<>();
        Set<Facility> set = facilities.keySet();
        facilities.forEach((key, value) -> {
            System.out.printf("%s - %s\n", key, value);
            for (Facility t : set) {
                stringList.add(t.toString() + "," + facilities.get(t));
            }
            File file = new File(path);
            FileWriter fileWriter;
            BufferedWriter bufferedWriter;
            try {
                fileWriter = new FileWriter(file, i);
                bufferedWriter = new BufferedWriter(fileWriter);
                for (String string : stringList) {
                    bufferedWriter.write(string);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
}}
