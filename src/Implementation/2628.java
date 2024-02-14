package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken()); // 가로 길이
        int height = Integer.parseInt(st.nextToken()); // 세로 길이
        int cut = Integer.parseInt(br.readLine()); // 잘라야하는 점선 개수

        ArrayList<Integer> wlist = new ArrayList<>(); // 가로 점선 번호 저장할 리스트
        ArrayList<Integer> hlist = new ArrayList<>(); // 세로 점선 번호 저장할 리스트
        wlist.add(0);
        hlist.add(0);

        for (int i = 0; i < cut; i++) {
            st = new StringTokenizer(br.readLine());

            int worh = Integer.parseInt(st.nextToken()); // 자르는 점선 가로 or 세로
            int linenum = Integer.parseInt(st.nextToken()); // 자르는 점선 번호

            if (worh == 0 && linenum != 0) { // 가로 점선 번호 리스트에 추가
                hlist.add(linenum);
            } else { // 세로 점선 번호 리스트에 추가
                if (linenum != 0) wlist.add(linenum);
            }
        }

        // 오름차순 정렬
        Collections.sort(wlist);
        Collections.sort(hlist);

        // 각 배열에 가로, 세로줄 잘린 칸 수 저장
        int[] warr = new int[wlist.size()];
        int[] harr = new int[hlist.size()];

        // 마지막 조각 전까지
        for (int i = 0; i < wlist.size() - 1; i++) {
            warr[i] = wlist.get(i + 1) - wlist.get(i);
        }
        warr[wlist.size() - 1] = width - wlist.get(wlist.size() - 1); // 마지막 조각

        // 마지막 조각 전까지
        for (int i = 0; i < hlist.size() - 1; i++) {
            harr[i] = hlist.get(i + 1) - hlist.get(i);
        }
        harr[hlist.size() - 1] = height - hlist.get(hlist.size() - 1); // 마지막 조각

        // 조각 길이 오름차순 정렬
        Arrays.sort(warr);
        Arrays.sort(harr);

        // 가로, 세로 조각 최대값끼리 곱
        System.out.println(warr[wlist.size() - 1] * harr[hlist.size() - 1]);

    }
}
