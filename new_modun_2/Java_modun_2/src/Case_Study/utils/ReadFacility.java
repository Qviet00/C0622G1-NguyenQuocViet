package Case_Study.utils;

import Case_Study.models.Facility.Facility;
import Case_Study.models.Facility.House;
import Case_Study.models.Facility.Room;
import Case_Study.models.Facility.Villa;

import java.io.*;
import java.util.*;

public class ReadFacility {
    public static Map<Facility, Integer> readFacilityFile(String path) {
        Map<Facility, Integer> facilities = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                if (info.length == 10) {
                    facilities.put(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                            Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8])), Integer.parseInt(info[9]));
                } else if (info.length == 9) {
                    facilities.put(new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                            Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
                } else if (info.length == 8) {
                    facilities.put(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                            Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilities;
    }


}