package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1010 {
    // 최대 30개의 N, M
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            // M(n)개 중에 N(r)개 (nCr)
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(comb(M, N)).append("\n");
        }

        System.out.println(sb);
    }

    public static int comb(int n, int r) {
        if (dp[n][r] > 0) { // 이미 계산돼있는 경우 바로 반환
            return dp[n][r];
        }

        if (r == n || r == 0) { // nCn = nC0 = 1
            return dp[n][r] = 1;
        }

        // 일반적인 경우 (n+1Cr+1 = nCr + nCr+1)
        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
