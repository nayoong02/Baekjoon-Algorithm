package Greedy;

import java.util.Scanner;

class Main_14916 {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       int n = scan.nextInt(); // 거스름돈
       int count = 0; // 동전 개수

       while (true) {
           if (n % 5 == 0) {
               count += n / 5;
               System.out.println(count);
               break;
           }
           n -= 2;
           count++;

           if (n < 0) {
               System.out.println(-1);
               break;
           }
       }

    }
}