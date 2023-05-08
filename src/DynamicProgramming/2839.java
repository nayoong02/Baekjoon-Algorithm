package DynamicProgramming;

import java.util.Scanner;

// 첫 번째 방법
//class Main_2839 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int N = scan.nextInt();
//
//        if (N == 4 || N == 7) {
//            System.out.println(-1);
//        } else if (N % 5 == 0) {
//            System.out.println(N / 5);
//        } else if (N % 5 == 1 || N % 5 == 3) {
//            System.out.println(N / 5 + 1);
//        } else if (N % 5 == 2 || N % 5 == 4) {
//            System.out.println(N / 5 + 2);
//        }
//    }
//}

// 두 번째 방법
class Main_2839 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count = 0;

        while (true) {
            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                break;
            }
            else if (N < 0) {
                System.out.println(-1);
                break;
            }
            N -= 3;
            count++;
        }
    }
}