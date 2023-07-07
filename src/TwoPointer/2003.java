package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int[] arr = new int[N];

        // 배열에 각 원소 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int sum = 0;

        while(true) {
            if (sum >= M) { // sum이 M보다 같거나 크면 arr[start] 더해주고 start++
                sum -= arr[start++];
            } else if (end >= N) { // end 가 N-1 인덱스를 넘어가면 종료
                break;
            } else { // 인덱스들이 범위 안에 있고 sum이 M보다 작으면 arr[end] 더해주고 end++
                sum += arr[end++];
            }

            if (sum == M) { // 딱 M과 같으면 count++
                count++;
            }
        }

        System.out.println(count);

    }
}