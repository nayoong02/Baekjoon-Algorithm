package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aCount = Integer.parseInt(st.nextToken()); // 집합 A 크기
        int bCount = Integer.parseInt(st.nextToken()); // 집합 B 크기

        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aCount; i++) { // 집합 A 원소 모두 넣고
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bCount; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (set.contains(num)) { // 집합에 B 원소 이미 있으면 제거,
                set.remove(num);
            } else { // 없으면 집합에 추가
                set.add(num);
            }
        }

        System.out.println(set.size());
    }
}
