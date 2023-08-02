package Implementation;

import java.util.Scanner;

class Main_2578 {
    static int[][] bingo;
    static int count;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        bingo = new int[5][5];

        // 입력 받은 빙고판
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = scan.nextInt();
            }
        }

        // 사회자가 불러준 숫자 -> 빙고판에서 찾으면 0으로 매핑
        for (int i = 1; i <= 25; i++) {
            int num = scan.nextInt();

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (bingo[j][k] == num) bingo[j][k] = 0;
                }
            }

            rowCheck();
            colCheck();
            upDiagonal();
            downDiagonal();

            if (count >= 3) { // 3줄 이상 빙고 -> 몇번 째로 부른 숫자인지 출력
                System.out.println(i);
                break;
            }
            count = 0; // 빙고 줄 수 초기화
        }

     }

     // 행 체크
     public static void rowCheck() {
         for (int i = 0; i < 5; i++) {
             int zeroCount = 0;

             for (int j = 0; j < 5; j++) {
                 if (bingo[i][j] == 0) zeroCount++;
             }
             if (zeroCount == 5) {
                 count++;
             }
         }
     }

    // 열 체크
     public static void colCheck() {
         for (int i = 0; i < 5; i++) {
             int zeroCount = 0;

             for (int j = 0; j < 5; j++) {
                 if (bingo[j][i] == 0) zeroCount++;
             }
             if (zeroCount == 5) {
                 count++;
             }
         }
     }

    // 위로 대각선 체크
     public static void upDiagonal() {
         int zeroCount = 0;

         for (int i = 0; i < 5; i++) {
             if (bingo[i][4 - i] == 0) zeroCount++;
         }
         if (zeroCount == 5) count++;
    }

    // 아래로 대각선 체크
     public static void downDiagonal() {
         int zeroCount = 0;

         for (int i = 0; i < 5; i++) {
             if (bingo[i][i] == 0) zeroCount++;
         }
         if (zeroCount == 5) count++;
     }

}
