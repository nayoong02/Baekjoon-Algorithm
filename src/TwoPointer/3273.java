package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 원소들 배열에 저장
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 연속성 부여를 위한 정렬

        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n - 1;
        int count = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum >= x) end--;
            else if(sum < x) start++;
            if (sum == x) count++;
        }

        System.out.println(count);

    }
}
