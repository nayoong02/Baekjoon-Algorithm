import java.util.Scanner;

class Main_2630 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] ans = new int[n]; //정답 배열

        for(int i = 0; i < n; i++) {
            int m = scan.nextInt();
            ans[i] = step(m);
        }

        for(int j = 0; j < n; j++) {
            System.out.println(ans[j]);
        }
    }

    public static int step(int m) {
        if(m < 0) {
            return 0;
        }
        else if(m == 0) {
            return 1;
        }
        else {
            return step(m - 1) + step(m - 2) + step(m - 3);
        }
    }
}