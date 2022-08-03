package ss_3_loop_java.ss_1_practice_java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);
        int i;
        int j;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 10; j++) {
                if (i == 0 || i == 8) {
                    if (j == 4 || j == 5) {
                        System.out.println("1");
                    } else {
                        System.out.println(" ");
                    }
                    if (i == 0 || i == 8) {
                        if (j == 4 || j == 5) {
                            System.out.println("1");
                        } else {
                            System.out.println(" ");
                        }
                        if (i == 1 || i == 7) {
                            if (j == 3 || j == 6) {
                                System.out.println("2");
                            } else {
                                System.out.println(" ");
                            }
                            if (i == 2 || i == 6) {
                                if (j == 2 || j == 7) {
                                    System.out.println("3");
                                } else {
                                    System.out.println(" ");
                                }
                                if (i == 3 || i == 5) {
                                    if (j == 4 || j == 5) {
                                        System.out.println("4");
                                    } else {
                                        System.out.println(" ");
                                    }
                                    if (i == 4 || j == 4) {
                                        System.out.println("5");
                                    } else {
                                        System.out.println(" ");
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
