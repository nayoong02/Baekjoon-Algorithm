package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long ans = LCM(a, b);
            System.out.println(ans);

        }
    }

    // 최소공배수 구하기
    public static long LCM(int a, int b) {
        long big, small;
        small = Math.min(a, b);
        big = Math.max(a, b);

        long gcd = GCD(big, small);
        long lcm = (big * small) / gcd;

        return lcm;
    }

    // 최대공약수 구하기
    public static long GCD(long big, long small) {
        if (big % small == 0) {
            return small;
        }
        return GCD(small, big % small);
    }
}