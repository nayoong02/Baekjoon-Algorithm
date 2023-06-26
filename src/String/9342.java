package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String word = br.readLine();

            if (word.matches("^[ABCDEF]?A+F+C+$[ABCDEF]?")) {
                sb.append("Infected!").append("\n");
            }
            else { sb.append("Good").append("\n"); }
        }

        System.out.println(sb);
    }

}
