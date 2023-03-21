package BruteForce; /**브루트포스 알고리즘**/
import java.util.Scanner;

class Main_1120{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        String y = scan.next();
        int count = 0;
        int ans = x.length();

        //x 길이만큼 y에서 반복문 돌며 차이 제일 적은 거 추출
        for(int i = 0; i < (y.length() - x.length() + 1); i++){
            count = 0;
            for(int j = 0; j < x.length(); j++){
                if(x.charAt(j) != y.charAt(j + i)) count++;
            }
            ans = Math.min(ans, count);
        }

        System.out.println(ans); 
    }
    
}