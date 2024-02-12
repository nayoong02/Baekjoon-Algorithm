package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_5014 {
    static int F, S, G, U, D;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 총 층 수
        S = Integer.parseInt(st.nextToken()); // 현재 위치
        G = Integer.parseInt(st.nextToken()); // 목표 위치
        U = Integer.parseInt(st.nextToken()); // 위로 이동할 층 수
        D = Integer.parseInt(st.nextToken()); // 아래로 이동할 층 수

        check = new int[F + 1];

        if (S == G) { // 같은 층이면 이동 필요 X
            System.out.println(0);
        } else { // 다른 층이면
            bfs(S);
        }
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        check[num] = 1;
        boolean flag = false;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < 2; i++) {
                int next;

                if (i == 0) { // U층 만큼 올라가기
                    next = temp + U;
                } else { // D층 만큼 올라가기
                    next = temp - D;
                }

                // G층에 다다르면
                if (next == G) {
                    flag = true;
                    System.out.println(check[temp]);
                    return;
                }

                // 다음 층 범위 안 && 아직 방문 전
                if (next >= 1 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }

        // G층에 다다를 수 없을 때
        if (!flag) {
            System.out.println("use the stairs");
        }

    }
}
