package DFS_BFS;

import java.util.*;
import java.io.*;

class Main_2668 {
    static int[] num;
    static boolean[] visited;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        num = new int[N + 1];

        // 1 ~ N 정수 입력 받기
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N + 1];
        list = new ArrayList<>();

        // 사이클 판별
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        // 리스트 크기 + 원소 출력
        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }

    // 사이클 판별 후 리스트에 추가
    public static void dfs(int start, int target) {
        if (num[start] == target) {
            list.add(target);
        }

        if (!visited[num[start]]) {
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]] = false;
        }
    }
}
