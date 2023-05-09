package BruteForce;

import java.util.Scanner;

class Main_15721 {
    static int A, T, type;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        A = scan.nextInt(); // 인원 수
        T = scan.nextInt(); // 구하고자 하는 번째 수
        type = scan.nextInt(); // 0 -> 뻔, 1 -> 데기

        System.out.println(sol());

    }

    private static int sol() {
        int repeat = 2; // 반복되는 횟수
        int bbun = 0; // 뻔
        int degi = 0; // 데기

        while (true) {
            // 첫 반복되는 4회 "뻔 - 데기 - 뻔 - 데기"
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) bbun++;
                else degi++;

                // 종료 조건
                if (type == 0 && bbun == T) {
                    return (bbun + degi - 1) % A;
                } else if (type == 1 && degi == T) {
                    return (bbun + degi - 1) % A;
                }
            }

            // 이후 반복되는 "뻔" * repeat
            for (int i = 0; i < repeat; i++) {
                bbun++;
                // 종료 조건
                if (type == 0 && bbun == T) {
                    return (bbun + degi - 1) % A;
                }
            }
            // 이후 반복되는 "데기" * repeat
            for (int i = 0; i < repeat; i++) {
                degi++;
                // 종료 조건
                if (type == 1 && degi == T) {
                    return (bbun + degi - 1) % A;
                }
            }
            repeat++;
        }
    }


}