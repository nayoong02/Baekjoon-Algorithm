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
                if (Math.abs(o1) < Math.abs(o2)) { // 절댓값 기준 오름차순 정렬
                    return -1;
                } else if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else { // 절댓값 같은 경우
                    if (o1 == o2) { // 부호가 같은 경우
                        return 0;
                    }
                    else { // 부호가 다른 경우
                        if (o1 < o2) { // 가장 작은 값부터 출력돼야하므로 오름차순 정렬
                            return -1;
                        } else {
                            return 1;
                        }
                    }
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