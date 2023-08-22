package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Num[] arr = new Num[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = new Num(num, i);
        }

        Arrays.sort(arr);
        int max = 0;

        // 앞으로 제일 많이 이동한 횟수 + 1
        for (int i = 0; i < n; i++) {
            if (arr[i].index - i > max) {
                max = arr[i].index - i;
            }
        }

        System.out.println(max + 1);
    }

    static class Num implements Comparable<Num> {
        int num;
        int index;

        Num(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Num o) { // 원속 기준 오름차순 정렬
            return num - o.num;
        }
    }
}
