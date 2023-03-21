package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1978{
    static int ans = 0; //정답 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //주어질 숫자 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            isPrime(a);
        }

        System.out.println(ans);

    }

    //소수 판별 함수
    public static void isPrime(int a){
        if(a < 2) { //a == 1
            return;
        } else if (a == 2) {
            ans += 1;
            return;
        }
        else {
            for(int i = 2; i <= Math.sqrt(a); i++){ //최대 a의 제곱근까지 나눠짐
                if(a % i == 0){ //나눠떨어지면 소수 x
                    return;
                }
            }
            ans += 1;
            return;
        }
    }
}