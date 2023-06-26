package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String line = br.readLine(); // 문자열
            int k = Integer.parseInt(br.readLine()); // 포함하는 정수 개수

            if (k == 1) {
                sb.append("1 1").append("\n");
                continue;
            }

            int[] alphabet = new int[26]; // 알파벳 별 개수 저장
            for (int j = 0; j < line.length(); j++) {
                alphabet[line.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE; // 최소 길이
            int max = -1; // 최대 길이
            for (int j = 0; j < line.length(); j++) {
                if (alphabet[line.charAt(j) - 'a'] < k) continue;

                int count = 1;
                for (int l = j + 1; l < line.length(); l++) { // 뒤로 해당 문자가 등장하는지 체크
                    if (line.charAt(l) == line.charAt(j)) count++;

                    if (count == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) sb.append(-1).append("\n");
            else sb.append(min + " " + max).append("\n");

        }

        System.out.println(sb);
    }
}
