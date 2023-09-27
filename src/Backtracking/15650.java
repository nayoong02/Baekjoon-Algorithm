package Backtracking;

import java.util.Scanner;

class Main_15650 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M];

        dfs(0, 0);
        System.out.println(sb);
    }

    // 오름차순 정렬이니까 start부터 오른쪽으로 +1
    public static void dfs(int start, int count) {
        if (count == M) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            arr[count] = i + 1;
            dfs(i + 1, count + 1);
        }
    }
}
