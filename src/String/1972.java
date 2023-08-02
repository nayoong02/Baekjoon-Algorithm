package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main_1972 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String word = br.readLine();
            if (word.equals("*")) break;

            if (check(word, word.length())) System.out.println(word + " is surprising.");
            else System.out.println(word + " is NOT surprising.");
        }
    }

    public static boolean check(String word, int len) {
        if (len == 1) { // 문자열 길이가 1이면 무조건 놀라운 문자열
            return true;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 2; i <= len; i++) { // 쪼갤 문자열 길이가 2, 3, ... len까지
            list.clear();
            int j = 0;

            while (true) {
                if (j + i < len) {
                    String slice = String.valueOf(word.charAt(j)).concat(String.valueOf(word.charAt(j + i - 1)));

                    if (!list.contains(slice)) list.add(slice); // 중복 체크
                    else {
                        return false;
                    }
                    j++; // 시작 인덱스 증가
                }
                else if (j + i == len) {
                    String slice = String.valueOf(word.charAt(j)).concat(String.valueOf(word.charAt(j + i - 1)));

                    if (!list.contains(slice)) { // 중복 체크
                        list.add(slice);
                        break; // 반복문 탈출
                    }
                    else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
