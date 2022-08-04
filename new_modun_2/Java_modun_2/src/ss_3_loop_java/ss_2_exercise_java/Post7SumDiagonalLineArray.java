package ss_3_loop_java.ss_2_exercise_java;

public class Post7SumDiagonalLineArray {
    public static void main(String[] args) {
        int[][] arrayDiagonalLine = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sumOne = 0;
        int sumTwo = 0;
        int i;
        int j;

        for (i = 0; i < arrayDiagonalLine.length; i++) {
            for (j = 0; j < arrayDiagonalLine[i].length; j++) {
                if (i == j) {
                    sumTwo += arrayDiagonalLine[i][j];
                }
            }
        }
        int sum = sumOne + sumTwo;
        System.out.println("Tổng hai đường chéo: " + sum);
    }

}