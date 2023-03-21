package DynamicProgramming;

import java.util.Scanner;

class Sol_1932 {
    static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        // 이차원 배열 입력 받기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i + 1; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        // dp 배열 완성
        dp[0][0] = arr[0][0];

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i + 1; j++){
                if (j == 0){
                    dp[i][j] = arr[i][j] + dp[i - 1][0];
                } else if (j == i) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j - 1];
                } else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        // dp 배열 마지막 행에서 최댓값 구하기
        int max = 0;
        for(int k = 0; k < N; k++){
            if (dp[N - 1][k] > max)
                max = dp[N - 1][k];
        }

        System.out.println(max);

    }
}