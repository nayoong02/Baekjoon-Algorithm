package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_20057 {
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dc = {1, 1, 2, 2}; // 방향별 움직이는 칸 수
    static int[][] dsx = { // 모래 퍼지는 x 방향
            {-1, 1, -2, -1, 1, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2},
            {1, -1, 2, 1, -1, -2, 1, -1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
    static int[][] dsy = { // 모래 퍼지는 y 방향
            {1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -2, -1, 1, 2, -1, 1, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 2, 1, -1, -2, 1, -1, 0}};
    static int[] sandRatio = {1, 1, 2, 7, 7, 2, 10, 10, 5}; // 비율

    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        // 행렬 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = calcOutSand(N / 2, N / 2);
        System.out.println(result);
    }

    public static int calcOutSand(int x, int y) {
        int totalOutSand = 0; // 밖으로 나가는 전체 모래 양
        // 현재 위치
        int currX = x;
        int currY = y;

        while (true) {
            for (int d = 0; d < 4; d++) { // 4방향
                for (int moveCount = 0; moveCount < dc[d]; moveCount++) { // 방향마다 움직이는 칸 수

                    // 현재 위치에서 이동
                    int nextX = currX + dx[d];
                    int nextY = currY + dy[d];

                    // 종료조건
                    if (nextX < 0 || nextY < 0) {
                        return totalOutSand;
                    }

                    // 모래 뿌리기
                    int sand = matrix[nextX][nextY]; // 이동한 위치의 원래 있던 모래의 양
                    matrix[nextX][nextY] = 0; // 다 비우기
                    int spreadTotal = 0; // 흩뿌리는 전체 양

                    // 9방향 비율대로 모래 뿌리기
                    for (int spread = 0; spread < 9; spread++) {
                        int sandX = nextX + dsx[d][spread];
                        int sandY = nextY + dsy[d][spread];
                        int spreadAmount = (sand * sandRatio[spread])/100; // 방향에 뿌릴 양

                        // 범위 체크
                        if (sandX < 0 || sandY < 0 || sandX >= N || sandY >= N) { // 범위 밖
                            totalOutSand += spreadAmount;
                        } else {
                            matrix[sandX][sandY] += spreadAmount;
                        }
                        spreadTotal += spreadAmount;
                    }

                    int alphaX = nextX + dx[d];
                    int alphaY = nextY + dy[d];
                    int alphaAmount = sand - spreadTotal; // 원래 있던 양 - 전체 흩뿌린 양

                    // 범위 체크
                    if (alphaX < 0 || alphaY < 0 || alphaX >= N || alphaY >= N) { // 범위 밖
                        totalOutSand += alphaAmount;
                    } else {
                        matrix[alphaX][alphaY] += alphaAmount;
                    }

                    // 이동한 위치를 현재 위치로 업데이트
                    currX = nextX;
                    currY = nextY;
                }
            }

            for (int idx = 0; idx < 4; idx++) { // dc 배열 돌면서 각각 +2
                dc[idx] += 2;
            }
        }
    }
}
