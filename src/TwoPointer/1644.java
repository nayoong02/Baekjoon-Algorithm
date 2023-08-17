package TwoPointer;

import java.util.ArrayList;
import java.util.Scanner;

class Main_1644 {
    public static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int sum = 0;
        int answer = 0;
        int start = 0;
        int end = 0;
        list = decimal(n);

        while (end <= list.size()) {
            if (sum >= n) {
                if (sum == n) {
                    answer++;
                }
                sum -= list.get(start++);

            }
            else {
                if (end == list.size()) break;
                sum += list.get(end++);
            }
        }

        System.out.println(answer);
    }

    public static ArrayList<Integer> decimal(int n) {
        list = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            if (i == 2) {
                list.add(i);
                continue;
            }

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) list.add(i);

        }

        return  list;
    }
}
