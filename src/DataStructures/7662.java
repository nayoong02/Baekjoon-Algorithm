package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 데이터 수

        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>(); // 우선순위 큐 역할 트리맵
            int k = Integer.parseInt(br.readLine()); // 연산 수

            for (int j = 0; j < k; j++) {
                String line = br.readLine();
                String op = line.split(" ")[0]; // 연산 종류
                int num = Integer.parseInt(line.split(" ")[1]); // 연산할 수

                if (op.equals("I")) { // 삽입
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                else { // 삭제
                    while (!map.isEmpty()) {
                        int key = (num == -1) ? map.firstKey() : map.lastKey();
                        if (map.get(key) == 1) { // value가 1이었다면 바로 remove
                            map.remove(key);
                        } else { // 1 이상이면 value - 1
                            map.put(key, map.get(key) - 1);
                        }
                        break;
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }

        }
    }
}
