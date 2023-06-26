package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Main_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine()); // 단어 개수

        for (int i = 0; i < n; i++) { // 중복 방지하며 리스트에 단어 추가
            String word = br.readLine();

            if (list.contains(word)) { continue; }
            else { list.add(word); }

        }

        Collections.sort(list, new Comparator<String>() { // 조건에 맞게 정렬
            @Override
            public int compare(String o1, String o2) {
                return o1.length() != o2.length() ? o1.length() - o2.length() : o1.compareTo(o2);
            }
        });

        for (String s : list) {
            System.out.println(s);
        }

    }

}
