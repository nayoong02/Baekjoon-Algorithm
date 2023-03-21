package BinarySearch; /**이분탐색**/
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_10815 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;

    public static void main(String args[]) throws IOException {
        n = Integer.parseInt(br.readLine()); //주어진 숫자 개수
        arr = new int[n]; //주어진 숫자 넣을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) { //주어진 숫자
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine()); //탐색할 숫자 개수
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) { //탐색할 숫자 이분탐색
            int target = Integer.parseInt(st.nextToken());
            if (BinarySearch(target)) bw.write("1 ");
            else bw.write("0 ");
        }

        bw.close();
        br.close();

    }

    public static boolean BinarySearch(int target) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}