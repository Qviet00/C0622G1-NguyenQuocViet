package ss_14_Sort_Algorithm.Post2;

import java.util.Arrays;

public class InsertSort {
    public static int[] insertionSort(int[] array) {
        int pos, x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array= new int[]{1,5,4,3,7,8,34,25};
        System.out.println(Arrays.toString(insertionSort(array)));
    }
}
