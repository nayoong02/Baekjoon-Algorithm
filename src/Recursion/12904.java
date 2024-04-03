package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_12904 {
    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        if (change(T)) System.out.println(1);
        else System.out.println(0);
    }

    public static boolean change(String T) {
        if (T.length() == S.length()) {
            if (T.equals(S)) return true;
            else return false;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            T = T.substring(0, T.length() - 1); // 맨 뒤 A 제거

            // 재귀
            return change(T);
        }

        if (T.charAt(T.length() - 1) == 'B') {
            T = T.substring(0, T.length() - 1); // 맨 뒤 B 제거
            StringBuffer sb = new StringBuffer(T);
            T = sb.reverse().toString(); // 뒤집기

            // 재귀
            return change(T);
        }

        return false;
    }
}
