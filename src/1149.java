import java.util.Scanner;

class Main_1149 {
    static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        // 배열 채워넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        // dp 배열 완성
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else {
                    if (j == 0) {
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]);
                    } else if (j == 1) {
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]);
                    } else {
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j - 2], dp[i - 1][j - 1]);
                    }

                }

            }
        }

        // dp 배열 마지막 행에서 최솟값 찾기
        int min = dp[N - 1][0];
        for (int k = 0; k < 3; k++) {
            if (dp[N - 1][k] < min) {
                min = dp[N - 1][k];
            }
        }

        System.out.println(min);

    }
}