package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String word = br.readLine();

            if (palindrome(word)) {
                System.out.println(0);
            } else if (pseudo(word)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }

    public static boolean palindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) { // 다르면 false 리턴
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean pseudo(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) { // 다르면 left 제외 전후로 체크 or right 제외 전후로 체크해보기
                return palindrome(word.substring(0, left) + word.substring(left + 1)) || palindrome(word.substring(0, right) + word.substring(right + 1));
            }
            left++;
            right--;
        }
        return true;
    }

}
