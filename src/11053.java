/**DP**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_11053{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; //값 담을 배열
        int[] dp = new int[n]; //부분수열 개수 담을 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        //dp 배열 중 최대값 찾기
        int max = 0;
        for(int d : dp){
            max = Math.max(d, max);
        }

        System.out.println(max);

    }
}