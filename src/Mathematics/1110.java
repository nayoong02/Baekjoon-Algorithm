package Mathematics;

import java.util.Scanner;

class Main_1110 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int ans = 0; // 사이클 개수

        int tmp = N;
        while (true) {
            if (tmp < 10) { // 10보다 작으면 앞에 0 붙이고 합 더해주기
                tmp = tmp * 10 + tmp;
            }
            else {
                int sum = tmp % 10; // 합에 더해질 일의 자리
                int ten = sum; // 다음 숫자의 십의 자리수
                tmp /= 10;
                sum += tmp % 10;

                tmp = ten * 10 + sum % 10;
            }

            if (tmp == N) break;
            else ans++;
        }

        System.out.println(ans + 1);
    }
}
