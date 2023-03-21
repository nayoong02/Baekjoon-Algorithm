package DataStructures;

import java.util.HashSet;
import java.util.Scanner;

class Main_14425 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            set.add(scan.next());
        }

        int ans = 0;
        for(int j = 0; j < M; j++) {
            if(set.contains(scan.next())) {
                ans += 1;
            }
        }

        System.out.println(ans);

    }
}