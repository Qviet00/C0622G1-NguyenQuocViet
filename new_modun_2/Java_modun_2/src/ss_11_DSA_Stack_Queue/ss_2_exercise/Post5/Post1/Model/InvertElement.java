package ss_11_DSA_Stack_Queue.ss_2_exercise.Post5.Post1.Model;

public class InvertElement {
    private static void invert(char[] array, int index1, int index2) {
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void reverse(char[] array) {
        int n = array.length;
        int i;
        for (i = 0; i < n / 2; i++) {
            invert(array, i, n - i - 1);
        }
    }
}

