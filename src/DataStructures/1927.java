package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int op = Integer.parseInt(br.readLine());

            if (op == 0) { // delete
                if (!queue.isEmpty()) { // 큐가 비어있지 않으면 poll
                    System.out.println(queue.poll());
                }
                else System.out.println(0); // 비어 있으면 0 출력
            } else { // add
                queue.add(op);
            }
        }
    }

}