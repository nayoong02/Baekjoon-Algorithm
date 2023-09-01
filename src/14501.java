import java.io.*;
import java.util.*;

class Main_14501 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] t = new int[N];
        int[] p = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken()); // T
            p[i] = Integer.parseInt(st.nextToken()); // P
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            if (i + t[i] <= N) { // 날짜 안 넘어가면
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }

            // 상담 중에도 이전날까지의 최대 비용 저장되어야 있어야하니까
            // 오늘날까지의 최대 수익과 비교해 다음날의 결과값 중 최대값 갱신
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);
    }

}
