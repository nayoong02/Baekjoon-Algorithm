package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_1764 {
    static int N;
    static int M;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> NoListen = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String nolisten = br.readLine();
            NoListen.add(nolisten);
        }

        ArrayList<String> NoListenNSee = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String nosee = br.readLine();
            if (NoListen.contains(nosee)) {
                NoListenNSee.add(nosee);
            }
        }

        Collections.sort(NoListenNSee);
        System.out.println(NoListenNSee.size());

        for (String s : NoListenNSee) {
            System.out.println(s);
        }

    }
}