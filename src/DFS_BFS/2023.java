package DFS_BFS;

import java.util.Scanner;

class Main_2023 {
    static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        // 소수로 시작해야 함.
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

    }

    static void dfs(int num, int count) {
        if (count == N) { // 자릿수 만족되면 출력
            System.out.println(num);
        }
        for (int i = 1; i <= 9; i++) { // 자릿수 1씩 늘려나가며 소수인지 판정
            int temp = num * 10 + i;

            if (isPrime(temp)) { // 소수이면 자릿수 하나 늘려서 dfs 재귀 호출
                dfs(temp, count + 1);
            }
        }
    }

    // 소수 판정
    static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
