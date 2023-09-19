package DynamicProgramming;

import java.util.Scanner;

class Main_9656 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 돌 개수

        int count = 0; // 순서
        while (N > 0) {
            if (N > 3) {
                N -= 3;
                count++;
            } else {
                N -= 1;
                count++;
            }
        }

        // 순서가 짝수이면 창영이 진거고, 홀수면 상근이 진거임.
        if (count % 2 == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
