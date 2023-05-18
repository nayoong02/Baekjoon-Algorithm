package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_2606 {
    static int[][] map;
    static boolean[] visited;
    static int n, m;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 컴퓨터 수 (정점)
        m = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수 (간선)

        map = new int[n + 1][n + 1]; // 각 정점간 탐색 경로 저장할 배열
        visited = new boolean[n + 1]; // 정점 탐색 여부 담을 배열

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);

            map[a][b] = map[b][a] = 1;
        }

        System.out.println(dfs(1)); // 1부터 탐색 시작
    }

    public static int dfs(int i) {
        visited[i] = true;

        for (int j = 1; j <= n; j++) {
            if (map[i][j] == 1 && !visited[j]) { // 연결은 돼있지만 아직 방문 전일 때
                count++;
                dfs(j);
            }
        }
        return count;
    }

}