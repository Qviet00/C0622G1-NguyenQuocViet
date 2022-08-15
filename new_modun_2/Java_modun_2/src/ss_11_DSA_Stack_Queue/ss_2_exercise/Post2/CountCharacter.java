package ss_11_DSA_Stack_Queue.ss_2_exercise.Post2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhap gi di ban: ");
        String string = String.valueOf(src.nextLine());
        String[] array = string.split(" ");
        String key;
        Integer value;
        HashMap<String, Integer> Map = new HashMap<>();
        for (String s : array) {
            key = s;
            if (Map.containsKey(key)) {
                value = Map.get(key);
                Map.remove(key);
                Map.put(key, value + 1);
            } else {
                Map.put(key, 1);
            }
        }
        Set set = Map.keySet();
        for (Object o : set) {
            key = (String) o;
            System.out.println("Tu: " + key + " ->Xuat hien " + Map.get(key) + " lan");
        }
    }
}