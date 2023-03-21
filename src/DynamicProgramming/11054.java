package DynamicProgramming; /**DP**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_11054{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; //값 담을 배열
        int[] dp_l = new int[n]; //왼쪽부터 부분수열 개수 담을 배열
        int[] dp_r = new int[n]; //오른쪽부터 부분수열 개수 담을 배열
        int[] result = new int[n]; //dp_l, dp_r 합할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //dp_l
        dp_l[0] = 1;
        for(int i = 0; i < n; i++){
            dp_l[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp_l[i] <= dp_l[j]){
                    dp_l[i] = dp_l[j] + 1;
                }
            }
        }

        //dp_r
        dp_r[n-1] = 1;
        for(int i = n - 2; i >= 0; i--){
            dp_r[i] = 1;
            for(int j = n - 1; i < j; j--){
                if(arr[j] < arr[i] && dp_r[i] <= dp_r[j]){
                    dp_r[i] = dp_r[j] + 1;
                }
            }
        }

        //dp_l + dp_r 합치고 중복 제외
        for(int i = 0; i < n; i++){
            result[i] = dp_l[i] + dp_r[i] - 1;
        }

        //result 배열 중 최대값 찾기
        int max = 0;
        for(int d : result){
            max = Math.max(d, max);
        }

        System.out.println(max);
    }
}