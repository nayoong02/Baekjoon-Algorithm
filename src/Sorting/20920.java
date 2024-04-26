package Sorting;

import java.util.*;
import java.io.*;

class Main_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken()); // 단어의 개수
        int M = Integer.parseInt(st.nextToken()); // 단어의 길이 기준

        // 단어 길이 M보다 길면 맵에 횟수 카운트
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // 키를 단어 리스트에 추가
        ArrayList<String> list = new ArrayList<>(map.keySet());

        // 정렬
        Collections.sort(list, ((o1, o2) -> map.get(o1) == map.get(o2) ? (o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length()) : map.get(o2) - map.get(o1)));

        StringBuilder sb = new StringBuilder();
        for (String w : list) {
            sb.append(w).append("\n");
        }

        System.out.println(sb);
    }
}
