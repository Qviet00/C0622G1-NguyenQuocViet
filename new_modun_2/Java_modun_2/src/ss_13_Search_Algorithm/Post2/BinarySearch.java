package ss_13_Search_Algorithm.Post2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    int binarySearch(int[] arr, int left, int right, int x) {
        if (right >= left) {
            int mid = (right + left) / 2;
            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, left, mid - 1, x);

            return binarySearch(arr, mid + 1, right, x);
        }
        return -1;
    }

    public static void main(String[] arr) {
        BinarySearch arrayOne = new BinarySearch();
        Scanner src = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int a = Integer.parseInt(src.nextLine());
        int[] array = new int[a];
        for (int i = 0; i < a; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = Integer.parseInt(src.next());
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int n = array.length;
        System.out.print("Enter element want to search: ");
        int x = src.nextInt();
        int result = arrayOne.binarySearch(array, 0, n - 1, x);
        if (result == -1)
            System.out.println("Not fond.");
        else
            System.out.println("Element: " + array[result] + ", Index: " + result);

    }
}
