package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 입력 받으면서 우선순위큐에 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        // N 전까지 뽑고
        for (int i = 1; i < N; i++) {
            queue.poll();
        }

        // N번째 출력
        System.out.println(queue.poll());

    }
}
