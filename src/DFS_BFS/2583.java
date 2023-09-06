package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main_2583 {
    static int[][] matrix;
    static boolean[][] visited;
    static int M, N, K;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        M = Integer.parseInt(line.split(" ")[0]);
        N = Integer.parseInt(line.split(" ")[1]);
        K = Integer.parseInt(line.split(" ")[2]);
        matrix = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            // 직사각형 내부 1로 표시
            for (int y = M - rightY; y < M - leftY; y++) {
                for (int x = leftX; x < rightX; x++) {
                    matrix[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) { // 영역 안칠해져 있고 아직 방문전이면
                    int area = dfs(i, j);
                    list.add(area);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int area : list) {
            System.out.print(area + " ");
        }
    }

    static int dfs(int i, int j) {
        visited[i][j] = true;
        int area = 1;

        for (int idx = 0; idx < 4; idx++) { // 4방향 돌면서
            int nx = j + dx[idx];
            int ny = i + dy[idx];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && matrix[ny][nx] == 0 && !visited[ny][nx]) {
                area += dfs(ny, nx); // 영역 더해주기
            }
        }

        return area;
    }
}
