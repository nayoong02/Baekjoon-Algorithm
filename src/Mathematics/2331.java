package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_2331 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int idx = 0;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(A);

        while(true) {
            int num = list.get(list.size() - 1);
            int tmp = 0;

            while (num != 0) {
                tmp += Math.pow(num % 10, P);
                num /= 10;
            }

            if (list.contains(tmp)) {
                idx = list.indexOf(tmp);
                break;
            }

            list.add(tmp);
        }

        System.out.println(idx);
    }
}
