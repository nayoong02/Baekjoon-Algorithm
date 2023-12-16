package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long q = (long) Math.sqrt(n); // 제곱근

        // q^2 ≥ n인 가장 작은 음이 아닌 정수 q
        if (q * q >= n) {
            System.out.println(q);
        } else {
            System.out.println(q + 1);
        }
    }
}
