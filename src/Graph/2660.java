package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 회원 수
        int[][] matrix = new int[N + 1][N + 1];

        // 행렬 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                matrix[i][j] = 987654321;
                matrix[j][i] = 987654231;
            }
        }

        // 입력 받으면서 관계 연결
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 == -1 && n2 == -1) break; // 종료조건

            matrix[n1][n2] = matrix[n2][n1] = 1; // 친구 관계 (양방향)
        }

        // 플로이드-워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j], matrix[i][j]);
                }
            }
        }

        int[] score = new int[N + 1]; // 점수 저장할 배열
        int min = Integer.MAX_VALUE; // 점수 최소값

        // 최대 관계 수 저장
        for (int i = 1; i <= N; i++) {
            int max = Integer.MIN_VALUE; // 사람 달라질 때마다 초기화

            for (int j = 1; j <= N; j++) {
                if (matrix[i][j] == 0) continue;

                max = Math.max(matrix[i][j], max);
                score[i] = max;
            }
        }

        // 점수 배열 중 최소 점수 찾기 (회장 후보 점수)
        for (int i = 1; i <= N; i++) {
            min = Math.min(min, score[i]);
        }
        System.out.print(min + " ");

        int cnt = 0; // 회장 후보 수
        StringBuilder sb = new StringBuilder();

        // 최소 점수면 회장 후보 저장
        for (int i = 1; i <= N; i++) {
            if (score[i] == min) {
                cnt++;
                sb.append(i + " ");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);

    }
}
