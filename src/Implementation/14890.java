package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_14890 {
    static int N, L;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];

        // 지도 채우기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int[] col = new int[N];
        int[] row = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                row[j] = matrix[i][j]; // 행 추출
                col[j] = matrix[j][i]; // 열 추출
            }
            // 행, 열마다 체크
            if (canGo(row)) count++;
            if (canGo(col)) count++;
        }

        System.out.println(count);
    }

    static boolean canGo(int[] arr) {
        boolean[] visited = new boolean[N]; // 경사로 설치했는지 체크할 배열

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) { // 높이 같으면 pass
                continue;
            } else if (arr[i] - arr[i - 1] == 1) { // 다음 계단이 1 높은 경우
                for (int j = i - 1; j >= i - L; j--) { // 현재 i칸 이전의 칸들 L만큼 검사
                    // 범위를 벗어나고, 높이가 다르고, 경사로가 있는 곳이라면 실패
                    if (j < 0 || arr[j] != arr[i] - 1 || visited[j]) {
                        return false;
                    } else { // 경사로 설치
                        visited[j] = true;
                    }
                }
            } else if (arr[i] - arr[i - 1] == -1) { // 다음 계단이 1 낮은 경우
                for (int j = i; j < i + L; j++) { // 다음 계단부터 L개만큼 검사
                    // 범위를 벗어나고, 높이가 다르고, 경사로가 있는 곳이라면 실패
                    if (j >= N || arr[j] != arr[i] || visited[j]) {
                        return false;
                    } else { // 경사로 설치
                        visited[j] = true;
                    }
                }
            } else { // 계단 높이 차가 1보다 크면
                return false;
            }
        }
        return true;
    }
}
