package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_1012 {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int M, N, K, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        StringTokenizer st;
        for (int t = 0; t < T; t++) { // 테스트케이스만큼 반복
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추 심어진 위치 개수

            // 행렬, 방문 배열 초기화
            matrix = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 가로 인덱스
                int y = Integer.parseInt(st.nextToken()); // 세로 인덱스

                matrix[y][x] = 1;
            }

            ans = 0; // 각 테스트케이스마다 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == 1 && !visited[i][j]) {
                        ans++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpy = tmp[0]; // 현재 세로 인덱스
            int tmpx = tmp[1]; // 현재 가로 인덱스

            for (int i = 0; i < 4; i++) {
                int ny = tmpy + dy[i]; // 다음 세로 인덱스
                int nx = tmpx + dx[i]; // 다음 가로 인덱스

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) { // 범위 안
                    if (matrix[ny][nx] == 1 && !visited[ny][nx]) { // 배추 심어진 위치 & 방문 전
                        queue.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
