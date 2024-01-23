package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main_8979 {
    static int N, K;
    static List<Olimpic> list = new ArrayList<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 국가 수
        K = Integer.parseInt(st.nextToken()); // 알고 싶은 국가

        int country, gold, silver, bronze;

        // 리스트에 Olimpic 객체 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            country = Integer.parseInt(st.nextToken());
            gold = Integer.parseInt(st.nextToken());
            silver = Integer.parseInt(st.nextToken());
            bronze = Integer.parseInt(st.nextToken());

            list.add(new Olimpic(country, gold, silver, bronze, 0));
        }

        Collections.sort(list); // 객체 정렬
        list.get(0).rank = 1; // 첫 국가는 1등

        for (int i = 1; i < list.size(); i++) {
            Olimpic o = list.get(i); // 현재 국가
            Olimpic p = list.get(i - 1); // 전 국가

            if (o.compareTo(p) == 0) { // 전 국가와 같은 등수이면
                o.rank = p.rank;
            } else { // 다른 등수이면
                o.rank = i + 1;
            }

            if (o.country == K) { // 구하고자 하는 국가이면 인덱스 저장
                ans = i;
                break;
            }
        }

        System.out.println(list.get(ans).rank);
    }

    static class Olimpic implements Comparable<Olimpic> {
        int country;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Olimpic(int country, int gold, int silver, int bronze, int rank) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rank = rank;
        }

        // 메달 내림차순 정렬 (금 > 은 > 동)
        @Override
        public int compareTo(Olimpic o) {
            if (o.gold != this.gold) {
                return o.gold - this.gold;
            }
            if (o.silver != this.silver) {
                return o.silver - this.silver;
            }
            return o.bronze - this.bronze;
        }
    }
}
