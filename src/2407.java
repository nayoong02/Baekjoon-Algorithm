import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

class Main_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);

        BigInteger[][] dp = new BigInteger[101][101];

        // 파스칼 삼각형
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = BigInteger.ONE;
                } else {
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}