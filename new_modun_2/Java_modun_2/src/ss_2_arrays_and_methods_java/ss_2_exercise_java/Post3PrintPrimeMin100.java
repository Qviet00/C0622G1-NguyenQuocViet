package ss_2_arrays_and_methods_java.ss_2_exercise_java;

public class Post3PrintPrimeMin100 {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố: ");
        int count;
        for (int i = 1; i <= 100; i++) {
            count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(i);
            }
        }
    }
}