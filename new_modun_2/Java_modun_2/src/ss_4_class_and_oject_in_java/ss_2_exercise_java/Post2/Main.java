package ss_4_class_and_oject_in_java.ss_2_exercise_java.Post2;

import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i = 0; i < 1000; i++) {
            System.out.println("tex");
        }
        long end = System.currentTimeMillis();
        System.out.println(end);
        StopWatch timeStart = new StopWatch(start, end);
        System.out.println("Thời gian thực hiện: " + timeStart.getElapsedTime());
    }
}

