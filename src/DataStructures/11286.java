package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) { // 절대값 같으면 음수 우선 정렬
                    return o1 < o2 ? -1 : 1;
                }
                else { // 아니면 그냥 오름차순 정렬
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        for (int i = 0; i < N; i++) {
            int op = Integer.parseInt(br.readLine());

            if (op == 0) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else System.out.println(0);
            }
            else {
                queue.add(op);
            }
        }

    }
}