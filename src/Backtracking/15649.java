package Backtracking;

import java.util.Scanner;

class Main_15649 {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M];
        visited = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int count) {
        if (count == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 0; j < N; j++) {
            if (visited[j] == false) {
                visited[j] = true;
                arr[count] = j + 1;
                dfs(count + 1);

                visited[j] = false;
            }
        }
    }
}
