package DynamicProgramming; // Bottom - Up

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] dp = new Integer[N + 1];

        dp[0] = dp[1] = 0;

        // dp[N - 1] + 1 vs (dp[N/2] + 1) vs (dp[N/3] + 1) 중 최솟값 갱신
        for (int i = 2; i <= N; i++) {
            // 1 빼주기 dp[N - 1] + 1
            dp[i] = dp[i - 1] + 1;

            // 2로 나눠준 값 + 1 (dp[N/2] + 1)
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 1 빼준 값, 2로 나눈 값 중 최솟값
            }

            // 3으로 나눠준 값 + 1 (dp[N/3] + 1)
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 1 빼준 값, 2로 나눈 값, 3으로 나눈 값 중 최솟값
            }
        }

        System.out.print(dp[N]);
    }
}
