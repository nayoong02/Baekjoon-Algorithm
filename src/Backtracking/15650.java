package Backtracking;

import java.util.Scanner;

class Main_15650 {
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
        back(0, 0);
        System.out.println(sb);
    }

    public static void back(int start, int count) {
        if (count == M) {
            for (int a : arr) {
                sb.append(a + 1).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                arr[count] = i;
                back(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}
