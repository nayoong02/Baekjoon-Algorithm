import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_17218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int n = first.length();
        int m = second.length();
        int[][] dp = new int[n + 1][m + 1];

        // LCS 길이 찾기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 이전까지 만들어둔 LCS의 길이가 더 긴 값 누적
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 백트래킹
        StringBuilder sb = new StringBuilder();
        int count = dp[n][m]; // LCS 길이
        int row = n;
        int col = m;

        while(count > 0) {
            if (count == dp[row - 1][col]) {
                row--;
            } else if (count == dp[row][col - 1]) {
                col--;
            } else { // first.charAt(i) == second.charAt(j)
                sb.append(first.charAt(row - 1));
                row--;
                col--;
                count--;
            }
        }

        System.out.println(sb.reverse());

    }
}