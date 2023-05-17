package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 수
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            arr[i][0] = Integer.parseInt(line.split(" ")[0]); // start
            arr[i][1] = Integer.parseInt(line.split(" ")[1]); // end
        }

        // end 기준 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0; // 최대 회의 수
        int prev_end_time = 0; // 직전 끝난 회의 시간
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= prev_end_time) { // 직전 끝난 시간보다 같거나 이후이면
                prev_end_time = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}