package Recursion;

import java.io.*;

class Main_11729 {
    static int count;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoii(1, 2, 3, n);
        System.out.println(count);
        System.out.println(sb);
    }

    public static void hanoii(int from, int by, int to, int n) {
        if(n == 0) {
            return;
        }

        //n-1개를 from에서 by로 이동
        hanoii(from, to, by, n - 1);
        count++;
        //1개를 from에서 to로 이동
        sb.append(from + " " + to + "\n");
        //n-1개를 by에서 to로 이동
        hanoii(by, from, to, n - 1);

    }
}
