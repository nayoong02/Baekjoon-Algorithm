package String;

import java.util.ArrayList;
import java.util.Scanner;

class Main_1316 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        boolean flag;
        
        for (int i = 0; i < n; i++) {
            String word = scan.next();
            ArrayList<Character> list = new ArrayList<>();
            flag = true;
            
            for (int j = 0; j < word.length(); j++) {
                if (!list.contains(word.charAt(j))) {
                    list.add(word.charAt(j));
                } else if (list.contains(word.charAt(j)) && word.charAt(j) == word.charAt(j - 1)) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) count++;
            
        }
        System.out.println(count);
    }
}
