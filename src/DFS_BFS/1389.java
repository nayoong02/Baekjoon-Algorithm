package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_1389 {
    static int N, M;
    static int[][] matrix;
    static int result;
    static int minCount = Integer.MAX_VALUE;

    static class Info { // 인덱스랑 시작점 기준으로 각 정점까지의 단계 수 카운트를 저장하기 위한 클래스 생성
        int index, count;

        public Info(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점 수
        M = Integer.parseInt(st.nextToken()); // 간선 수

        matrix = new int[N + 1][N + 1]; // 인접 행렬
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 간선 연결
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        System.out.println(result);

    }

    public static void bfs(int i) {
        Queue<Info> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int count = 0;

        // 큐에 추가 후 방문 처리
        queue.offer(new Info(i, 0));
        visited[i] = true;

        while (!queue.isEmpty()) {
            Info c = queue.poll();
            count += c.count; // 큐에서 뽑은 객체의 현재 카운트 합산 (케빈 베이컨 수)

            for (int j = 1; j <= N; j++) {
                if (matrix[c.index][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.offer(new Info(j, c.count + 1)); // 단계+1 저장
                }
            }
        }

        if (minCount > count) { // 최소 케빈 베이컨 수를 만족하는 시작 점 구하기
            minCount = count;
            result = i;
        }

    }

}
