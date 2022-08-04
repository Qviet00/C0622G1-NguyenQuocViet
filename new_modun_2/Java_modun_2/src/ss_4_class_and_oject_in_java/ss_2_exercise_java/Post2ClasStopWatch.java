package ss_4_class_and_oject_in_java.ss_2_exercise_java;

import java.time.LocalTime;
import java.util.Scanner;

public class Post2ClasStopWatch {
    class StopWatch {
        private LocalTime startTime, endTime;

        public StopWatch() {
            startTime = LocalTime.now();
        }

        public StopWatch(LocalTime startTime, LocalTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        public void start() {
            startTime = LocalTime.now();
        }

        public void stop() {
            endTime = LocalTime.now();
        }

        public int getElapsedTime() {
            int miliSecond = ((endTime.getHour() - startTime.getHour()) * 3600 +
                    (endTime.getMinute() - startTime.getMinute()) * 60 + (endTime.getSecond()
                    - startTime.getSecond()) * 1000);
            return miliSecond;
        }
    }

    public static void main(String[] args) {
        Scanner src= new Scanner(System.in);

    }
}
