package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_7576 {
    static int M, N;
    static int[][] box;
    static Queue<Tomatoo> queue;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 상자 가로칸 수
        N = Integer.parseInt(st.nextToken()); // 상자 세로칸 수

        box = new int[N][M];
        queue = new LinkedList<Tomatoo>();

        // 토마토 창고 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토면 큐에 추가
                if (box[i][j] == 1) {
                    queue.add(new Tomatoo(i, j));
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Tomatoo tmp = queue.poll();
            int x = tmp.x;
            int y = tmp.y;

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (box[nx][ny] == 0) { // 아직 안 익었으면
                        queue.add(new Tomatoo(nx, ny)); // 큐에 추가
                        box[nx][ny] = box[x][y] + 1; // 일수 + 1
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE; // 걸린 날 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) return -1; // 안 익은 게 있으면 -1 리턴
                ans = Math.max(ans, box[i][j]); // 날짜 최댓값 갱신
            }
        }

        if (ans == 1) return 0; // 처음부터 다 익은거라면 0 리턴
        else return ans - 1; // 아니면 걸린 날 수 리턴 (처음 1부터 시작했을 것이므로 -1)
    }
}

class Tomatoo {
    int x; // 세로
    int y; // 가로

    public Tomatoo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
