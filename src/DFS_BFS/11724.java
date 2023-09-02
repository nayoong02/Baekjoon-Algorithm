package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_11724 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        // 인접리스트 초기화
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 양방향 간선 추가
            list[s].add(e);
            list[e].add(s);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int v) {
        if (visited[v]) return; // 방문된 지점까지 갔으면 리턴
        visited[v] = true;

        for (int i : list[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
