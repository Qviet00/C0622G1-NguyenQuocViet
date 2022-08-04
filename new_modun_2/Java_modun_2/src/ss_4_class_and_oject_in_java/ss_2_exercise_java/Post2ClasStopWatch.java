//package ss_4_class_and_oject_in_java.ss_2_exercise_java;
//
//import java.time.LocalTime;
//import java.util.Scanner;
//import java.util.Date;
//
//public class Post2ClasStopWatch {
//    class StopWatch {
//        private LocalTime startTime, endTime;
//
//        public StopWatch() {
//            startTime = LocalTime.now();
//        }
//
//        public StopWatch(LocalTime startTime, LocalTime endTime) {
//            this.startTime = startTime;
//            this.endTime = endTime;
//        }
//
//        public void start() {
//            startTime = LocalTime.now();
//        }
//
//        public void stop() {
//            endTime = LocalTime.now();
//        }
//
//        public int getElapsedTime() {
//            int miliSecond = System.currentTimeMillis();
//            return miliSecond;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner src = new Scanner(System.in);
//        LocalTime start = LocalTime.now();
//        LocalTime end = LocalTime.now();
//        StopWatch stop = new StopWatch(start, end);
//
//    }
//}
