package ss_13_Search_Algorithm.Post3;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxString {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        LinkedList<Character> pro = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        System.out.print("Enter string: ");
        String string = src.nextLine();
        for (int i = 0; i < string.length(); i++) {
            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
                list.clear();
            }
            list.add(string.charAt(i));
            if (list.size() > pro.size()) {
                pro.clear();
                pro.addAll(list);
            }
        }
        for (Character ch : pro) {
            System.out.print(ch);
        }
        System.out.println();
    }
}

