package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int Kim = Integer.parseInt(line.split(" ")[1]);
        int Lim = Integer.parseInt(line.split(" ")[2]);
        int round = 0;

        while (Kim != Lim) {
            Kim = Kim / 2 + Kim % 2;
            Lim = Lim / 2 + Lim % 2;
            round++;
        }

        System.out.println(round);
    }
}
