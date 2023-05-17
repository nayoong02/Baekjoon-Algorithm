package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            arr[i][0] = Integer.parseInt(line.split(" ")[0]);
            arr[i][1] = Integer.parseInt(line.split(" ")[1]);
        }
        // start 기준 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (i == 0) { // 첫 번째 end 큐에 넣기
                queue.add(arr[i][1]);
            } else {
                if (queue.peek() <= arr[i][0]) { // start가 큐에 저장된 end 보다 같거나 이후라면
                    queue.poll();
                }
                queue.add(arr[i][1]);
            }
        }

        System.out.println(queue.size());
    }
}
