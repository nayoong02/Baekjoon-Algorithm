package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String test = br.readLine();
            if (test.equals("end")) break; // 마지막 테스트 케이스

            if (vowels(test) && three(test) && twobuteeoo(test)) { // 3가지 조건 모두 통과
                System.out.println("<" + test + ">" + " is acceptable.");
            } else { // 1개라도 통과 X
                System.out.println("<" + test + ">" + " is not acceptable.");
            }
        }
    }

    // 모음 체크
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch=='u';
    }

    // 문자열에 모음 1개 이상 있는지 체크
    public static boolean vowels(String test) {
        if (test.contains("a") || test.contains("e") || test.contains("i") || test.contains("o") || test.contains("u")) {
            return true;
        }
        return false;
    }

    // 모음 or 자음 연속 3개인지 체크
    public static boolean three(String test) {
        for (int i = 2; i < test.length(); i++) {
            if (isVowel(test.charAt(i))) { // 모음이면
                if (isVowel(test.charAt(i - 1)) && isVowel(test.charAt(i - 2))) {
                    return false;
                }
            } else { // 자음이면
                if (!isVowel(test.charAt(i - 1)) && !isVowel(test.charAt(i - 2))) {
                    return false;
                }
            }
        }
        return true;
    }

    // 같은 글자 연속 두번 X but ee, oo는 가능
    public static boolean twobuteeoo(String test) {
        for (int i = 1; i < test.length(); i++) {
            if (test.charAt(i) == test.charAt(i - 1)) { // 연속되면
                if (test.charAt(i) != 'e' && test.charAt(i) != 'o') { // e나 o가 아니면
                    return false;
                }
            }
        }
        return true;
    }
}
