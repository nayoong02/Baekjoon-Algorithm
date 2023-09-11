package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_10816 {
    static int N, low, high, mid, target;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 배열 오름차순 정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) { // 타겟별로 upperbound - lowerbound
            target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, target) - lowerBound(arr, target)).append(" ");
        }

        System.out.println(sb);
    }

    static int lowerBound(int[] arr, int target) { // 타겟 전까지의 개수
        low = 0;
        high = arr.length;

        while (low < high) { // 같아질 때까지
            mid = (low + high) / 2;

            if (target <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upperBound(int[] arr, int target) { // 타겟 포함한 타겟까지의 개수
        low = 0;
        high = arr.length;

        while (low < high) {
            mid = (low + high) / 2;

            if (target >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
