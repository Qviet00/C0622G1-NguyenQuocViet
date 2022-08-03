package ss_2_arrays_and_methods_java.ss_2_exercise_java;

public class Post2Print20Prime {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố: ");
        int number = 0;
        int count = 1;
        for (int i = 1; i <= 20; ) {
            for (int j = 2; j <= Math.sqrt(count); j++) {
                if (count % j == 0) {
                    number = 0;
                    break;
                }
            }
            if (number != 0) {
                System.out.println(count);
                i++;
            }
            number = 1;
            count++;
        }
    }
}

