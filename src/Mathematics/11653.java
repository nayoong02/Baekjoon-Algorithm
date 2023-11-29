package Mathematics;

import java.util.Scanner;

class Main_11653 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        // 앞에서부터 나눌 수 있는 건 나눠가며 출력
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }

        // n이 1이 아니라면 (위에서 나눠지지 않았다면)
        if (n != 1) {
            System.out.println(n);
        }
    }
}
