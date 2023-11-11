package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_7569 {
    static int[][][] box; // 토마토 창고
    static int M, N, H;
    static int[] dx = {-1, 1, 0, 0, 0, 0}; // 상, 하, 좌, 우, 위, 아래
    static int[] dy = {0, 0, -1, 1, 0, 0}; // 상, 하, 좌, 우, 위, 아래
    static int[] dz = {0, 0, 0, 0, 1, -1}; // 상, 하, 좌, 우, 위, 아래
    static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 상자 가로칸 수
        N = Integer.parseInt(st.nextToken()); // 상자 세로칸 수
        H = Integer.parseInt(st.nextToken()); // 상자 높이

        box = new int[H][N][M]; // 면, 행, 열
        queue = new LinkedList<Tomato>();

        // 토마토판 입력
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    // 토마토가 익었다면 큐에 추가
                    if (box[i][j][k] == 1) queue.add(new Tomato(i, j, k));
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Tomato tmp = queue.poll();

            // 6방향마다 탐색
            for (int i = 0; i < 6; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int nz = tmp.z + dz[i];

                // 범위 체크
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
                    if (box[nz][nx][ny] == 0) { // 안익었으면
                        queue.add(new Tomato(nz, nx, ny)); // 큐에 추가
                        box[nz][nx][ny] = box[tmp.z][tmp.x][tmp.y] + 1; // 전 날짜 + 1
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE; // 최대 날짜
        for (int i = 0; i < H; i++) { // 창고 모두 돌면서
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 안 익은 게 있으면 -1 리턴
                    if (box[i][j][k] == 0) return -1;
                    // 날짜 최댓값 구하기
                    ans = Math.max(ans, box[i][j][k]);
                }
            }
        }

        // 원래부터 모두 익어있던 경우
        if (ans == 1) return 0;
        // 아니면 최댓값 - 1 (익은건 1부터 시작할테니까)
        else return ans - 1;
    }
}

class Tomato {
    int z; // 면
    int x; // 세로
    int y; // 가로

    Tomato(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
