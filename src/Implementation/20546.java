package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_20546 {
    static int money;
    static int[] arr;
    static int currCount, currMoney;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        money = Integer.parseInt(br.readLine()); // 공통으로 주어진 현금
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[14];

        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int jh = JH(arr, money);
        int sm = SM(arr, money);

        if (jh < sm) System.out.println("TIMING");
        else if (jh > sm) System.out.println("BNP");
        else System.out.println("SAMESAME");
    }

    // 전량 매수
    public static void buyAll(int todayCost, int count) {
        if (currMoney < todayCost * count) { // 현재 남은 금액 < 구매하려는 주식의 금액 -> 구매 불가
            return;
        }
        currCount += count; // 현재 가진 주식 수에 구매 가능 주식 수 더하기
        currMoney -= todayCost * count; // 구매 금액만큼 빼주기
    }

    // 전량 매도
    public static void sellAll(int todayCost) {
        currMoney += todayCost * currCount; // 오늘의 주가 * 현재 가진 주식 수
        currCount = 0; // 가진 주식 수 0으로 초기화
    }

    // 준현
    public static int JH(int[] arr, int money) {
        currMoney = money;
        currCount = 0;

        for (int price : arr) {
            int ableCount = currMoney / price; // 구매 가능한 주식 개수

            if (ableCount > 0) { // 구매 가능하면
                buyAll(price, ableCount);
            }

            if (currMoney == 0) break; // 현재 남은 금액이 0 되면 뒤에 연산 필요 x
        }

        int answer = arr[13] * currCount + currMoney;
        return answer;
    }

    // 성민
    public static int SM(int[] arr, int money) {
        currMoney = money;
        currCount = 0;

        for (int i = 3; i < 14; i++) {
            int ableCount = currMoney / arr[i];

            if (arr[i - 1] > arr[i - 2] && arr[i - 2] > arr[i - 3]) { // 3일 연속 상승 -> 전량 매도
                sellAll(arr[i]);
            }
            else if (arr[i - 1] < arr[i - 2] && arr[i - 2] < arr[i - 3]) { // 3일 연속 하락 -> 전량 매수
                buyAll(arr[i], ableCount);
            }
        }

        int answer = arr[13] * currCount + currMoney;
        return answer;
    }
}
