package DynamicProgramming;

import java.io.*;
import java.util.*;

class Main_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열 세로
        int M = Integer.parseInt(st.nextToken()); // 배열 가로

        if (N == 1 && M == 1) { // 게임판 크기가 1*1이면 바로 출력하고 종료
            System.out.println(br.readLine());
            System.exit(0);
        }

        int[][] dp = new int[N + 1][M + 1];
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 1; j <= M; j++) {
                int tmp = Integer.parseInt(input[j - 1]);

                if (i == 1 && j == 1) { // 맨 처음 (1, 1) 좌표는 그대로 넣어주기
                    dp[i][j] = tmp;
                } else { // 그 뒤부터는
                    if (tmp == 1) { // 1이면
                        // 왼쪽, 대각선 왼쪽 위, 위쪽 3가지 방향 중 최소값 + 1
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        // 최대 변의 길이 갱신
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }
        System.out.println(ans * ans);

    }
}
