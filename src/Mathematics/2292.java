package Mathematics;

import java.util.Scanner;

class Main_2292 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong();

        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }

        int start = 1;
        int mul = 1;
        int ans = 1;

        while (start < N) {
            start += 6 * mul;
            mul++;
            ans++;
        }

        System.out.println(ans);

    }
}
