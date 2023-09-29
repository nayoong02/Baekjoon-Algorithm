package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_14889 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        // N * N 행렬에 각각 능력치 넣어주기
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(min);

    }

    // 조합 구하는 함수
    static void combi(int idx, int count) {
        if (count == N / 2) { // 조합 완성되면 차이 구하러 가기
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) { // 아직 방문전이면 방문 처리 후 재귀 호출
                visited[i] = true;
                combi(i + 1, count + 1);

                // 다시 되돌려놓기
                visited[i] = false;
            }
        }
    }

    // 스타트팀, 링크팀 차 구하기
    static void diff() {
        int start = 0; // 스타트팀 합산
        int link = 0; // 링크팀 합산

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) { // i, j 모두 true면 -> start팀으로 간주
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if (!visited[i] && !visited[j]){ // i, j 모두 false면 -> link팀으로 간주
                    link += arr[i][j];
                    link += arr[j][i];
                }

            }
        }

        int val = Math.abs(start - link);

        // 최솟값이 0이면 더이상 볼 필요도 없이 바로 출력 후 종료
        if(min == 0) {
            System.out.println(min);
            System.exit(0);
        }

        min = Math.min(val, min);

    }
}
