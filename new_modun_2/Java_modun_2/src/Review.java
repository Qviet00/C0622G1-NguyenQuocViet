import java.util.Scanner;

public class Review {
    public static void main(String[] args) {
        int[] arr = new  int[ 3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập phần tử thứ "+i+": ");
            arr[i]= scanner.nextInt();
        }
        for (int b : arr
        ) {
            System.out.print(b);
        }
    }
}
