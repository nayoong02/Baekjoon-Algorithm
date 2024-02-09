package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main_1697 {
    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        N = Integer.parseInt(line.split(" ")[0]); // 수빈 위치
        K = Integer.parseInt(line.split(" ")[1]); // 동생 위치

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        check[num] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp - 1;
                } else if (i == 1) {
                    next = temp + 1;
                } else {
                    next = temp * 2;
                }

                // K에 다다르면 한 단계 전 (1초 뺀 값) 출력
                if (next == K) {
                    System.out.println(check[temp]);
                    return;
                }

                // next가 범위 안에 들어있고, 방문 전이라면
                if (next >= 0 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[temp] + 1;
                }

            }
        }
    }
}
