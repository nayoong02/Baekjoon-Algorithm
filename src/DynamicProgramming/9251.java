package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();

        int s1length = s1.length();
        int s2length = s2.length();

        int[][] dp = new int[s1length + 1][s2length + 1];

        for (int i = 1; i <= s1arr.length; i++) {
            for (int j = 1; j <= s2length; j++) {
                if (s1arr[i - 1] == s2arr[j - 1]) { // 두 문자가 일치하면 대각선 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else { // 일치하지 않으면 각 문자열 이전 문자 중 최대 lcs 선택
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[s1length][s2length]);
    }
}
