package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_21610 {
    static int N, M;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}; // 서쪽부터 시계방향으로 8방향
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static Queue<Cloud> clouds = new LinkedList<>(); // 구름 위치 저장할 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];
        visited = new boolean[N][N];

        // 행렬 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 번째 구름 생성
        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 2, 1));

        while (M-- > 0) {
            // 방향, 거리 입력 받기
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            // 구름 이동 후 비 내림 (+1)
            cloudsMove(d, s);

            // 구름 제거 후 대각선 탐색
            findDiagClouds();

            // 물 2 이상인 칸 구름 생성
            createCloudsover2();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println(sum);
    }

    // 구름 이동 후 비 내림 (+1)
    static void cloudsMove(int d, int s) {
        for (Cloud c : clouds) {
            c.x = (N + c.x + dx[d] * (s % N)) % N;
            c.y = (N + c.y + dy[d] * (s % N)) % N;

            matrix[c.x][c.y]++;
        }
    }

    // 구름 제거 후 대각선 탐색
    static void findDiagClouds() {
        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll(); // 구름 제거
            int count = 0;
            visited[cloud.x][cloud.y] = true;

            // 대각선 탐색
            for (int i = 1; i <= 7; i += 2) {
                int nx = cloud.x + dx[i];
                int ny = cloud.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 안에 있고
                    if (matrix[nx][ny] >= 1) { // 물 있으면
                        count++;
                    }
                }
            }
            matrix[cloud.x][cloud.y] += count; // 물 있는 칸 만큼 더해주기
        }
    }

    // 물 2 이상인 칸 구름 생성
    static void createCloudsover2() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && matrix[i][j] >= 2) { // 아까 제거 안된 구름 중에 2 이상인 칸
                    matrix[i][j] -= 2;
                    clouds.add(new Cloud(i, j)); // 구름 생성
                }
            }
        }
        visited = new boolean[N][N]; // 방문 배열 초기화
    }

    static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
