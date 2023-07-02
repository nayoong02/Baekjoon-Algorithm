package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> sub = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 원생 수
        int k = Integer.parseInt(st.nextToken()); // 조 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { // 키 리스트에 저장
            list.add(Integer.valueOf(st.nextToken()));
        }

        // 인접 키끼리 차이 구하기
        for (int i = 0; i < n - 1; i++) {
            sub.add(list.get(i + 1)- list.get(i));
        }

        Collections.sort(sub); // 키 차이 오름차순 정렬

        int ans = 0;
        for (int i = 0; i < n - k; i++) { // 제일 차이가 큰 k-1개 빼고 나머지 차이 합산
            ans += sub.get(i);
        }

        System.out.println(ans);
    }

}
