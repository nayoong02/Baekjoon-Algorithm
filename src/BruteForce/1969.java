package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int N = Integer.parseInt((line.split(" "))[0]); // DNA 개수
        int M = Integer.parseInt((line.split(" "))[1]); // DNA 길이
        String[][] arr = new String[N][M]; // DNA 저장할 2차원 배열
        String[] res = new String[M]; // Hamming Distance의 합이 가장 작은 DNA인 s
        int count = 0; // Hamming Distance의 합

        LinkedHashMap<String, Integer> nucleo = new LinkedHashMap<>(); // 순서 있는 해시맵
        nucleo.put("A", 0);
        nucleo.put("C", 0);
        nucleo.put("G", 0);
        nucleo.put("T", 0);

        // arr에 할당
        for (int i = 0; i < N; i++) {
           String dna = br.readLine();
           for (int j = 0; j < M; j++) {
               arr[i][j] = String.valueOf(dna.charAt(j));
           }
        }

        // 각 DNA 해당하는 key별 value 값 증가
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (arr[i][j].equals("A")) {
                    nucleo.put("A", nucleo.get("A") + 1);
                } else if (arr[i][j].equals("C")) {
                    nucleo.put("C", nucleo.get("C") + 1);
                } else if (arr[i][j].equals("G")) {
                    nucleo.put("G", nucleo.get("G") + 1);
                } else {
                    nucleo.put("T", nucleo.get("T") + 1);
                }
            }

            // 열마다 최대 빈도수 찾아 res 배열에 넣기
            int max = Collections.max(nucleo.values());
            for (String key : nucleo.keySet()) {
                int val = nucleo.get(key);
                if (val == max) {
                    res[j] = key;
                    break;
                }
            }
            // nucleo 배열 초기화
            for (String key : nucleo.keySet()) {
                nucleo.put(key, 0);
            }
        }

        // s 출력
        for (String r : res) {
            System.out.print(r);
        }
        System.out.println("");

        // count
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!arr[i][j].equals(res[j])) count++;
            }
        }

        System.out.println(count);
    }
}
