package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_5212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] matrix = new String[R][C];
        String[][] copyMatrix = new String[R][C]; // 복사본 배열
        for (int i = 0; i < R; i++) {
           String line = br.readLine();
            for (int j = 0; j < C; j++) {
                matrix[i][j] = line.split("")[j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int count = 0; // 인접 바다 카운트

                if (matrix[i][j].equals(".")) { // 바다면
                    continue;
                }
                else { // 땅이면 탐색 시작
                    if (i - 1 < 0) { // i == 0 이면 그 위 칸은 무조건 바다로 취급
                        count++;
                    } else if (matrix[i - 1][j].equals(".")) {
                        count++;
                    }
                    if (i + 1 >= R) { // i == R-1 이면 그 밑 칸은 무조건 바다로 취급
                        count++;
                    } else if (matrix[i + 1][j].equals(".")) {
                        count++;
                    }
                    if (j - 1 < 0) { // j == 0 이면 그 왼쪽 칸은 무조건 바다로 취급
                        count++;
                    } else if (matrix[i][j - 1].equals(".")) {
                        count++;
                    }
                    if (j + 1 >= C) { // j == C-1 이면 그 오른쪽 칸은 무조건 바다로 취급
                        count++;
                    } else if (matrix[i][j + 1].equals(".")) {
                        count++;
                    }

                    if (count < 3) { // 인접한 바다가 3개 미만이면 그대로 땅 유지
                        copyMatrix[i][j] = matrix[i][j];
                    }
                }
            }
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (copyMatrix[i][j] == null) copyMatrix[i][j] = "."; // 나머지 null은 바다로
                if (copyMatrix[i][j].equals("X")) {
                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                }
            }
        }

        // 바다가 존재하는 최소 ~ 최대 인덱스까지 배열 출력
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                System.out.print(copyMatrix[i][j]);
            }
            System.out.println("");
        }
    }

}
