package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main_24480 {
    static int N, M, R;
    static int count = 1;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 수
        M = Integer.parseInt(st.nextToken()); // 간선 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];

        // 리스트 초기화
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작점
            int v = Integer.parseInt(st.nextToken()); // 끝점

            // 무방향 그래프 연결
            list[u].add(v);
            list[v].add(u);
        }

        // 리스트 내림차순 정렬 (자식 여러 개일 때)
        for (ArrayList<Integer> i : list) {
            Collections.sort(i, Collections.reverseOrder());
        }

        dfs(R);
        for (int i = 1; i <= N; i++) { // ans 배열 출력
            System.out.println(ans[i]);
        }
    }

    public static void dfs(int r) {
        visited[r] = true;
        ans[r] = count++; // 순서 저장

        for (int i : list[r]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
