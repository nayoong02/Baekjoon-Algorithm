/**누적합 : accum[j] - accum[i - 1]**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_11659{
    static int[] arr, accum;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //수의 개수
        int m = Integer.parseInt(st.nextToken()); //합 구해야하는 횟수
        arr = new int[n + 1]; //주어진 수 저장할 배열
        accum = new int[n + 1]; //누적합 저장할 배열
        int sum = 0; //누적합

        //arr
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //accum
        for(int i = 1; i <= n; i++){
            sum += arr[i];
            accum[i] = sum;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int first_idx = Integer.parseInt(st.nextToken());
            int last_idx = Integer.parseInt(st.nextToken());
            accumulate(first_idx, last_idx);
            System.out.println(ans);
        }
    }

    public static void accumulate(int first_idx, int last_idx){
        ans = accum[last_idx] - accum[first_idx - 1];
    }
}