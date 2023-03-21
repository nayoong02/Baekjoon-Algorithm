package Sorting;

import java.util.Arrays;
import java.util.Scanner;

class Main_11656 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();
        String[] list = new String[word.length()];

        for(int i = 0; i < word.length(); i++) {
            list[i] = word.substring(i);
        }

        Arrays.sort(list);

        for(String li : list) {
            System.out.println(li);
        }

    }
}