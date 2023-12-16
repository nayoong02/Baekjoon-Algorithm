package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_2417_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        System.out.println(bSearch(n));
    }

    // 이분탐색
    static long bSearch(long n) {
        long start = 0;
        long end = n;
        long res = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (Math.pow(mid, 2) >= n) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
