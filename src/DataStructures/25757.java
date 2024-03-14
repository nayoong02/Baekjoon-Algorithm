package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]); // 임스와 같이 플레이를 신청한 횟수
        String game = line.split(" ")[1]; // N과 같이 플레이할 게임의 종류
        Set<String> set = new HashSet<>(); // 플레이어들 담을 집합

        // 집합에 플레이어들 담기
        for (int i = 0; i < N; i++) {
            String player = br.readLine();
            set.add(player);
        }

        int size = set.size();
        int ans = 0;
        switch (game) {
            case "Y": // 윷놀이
                ans = size;
                break;
            case "F": // 틀린그림찾기
                ans = size / 2;
                break;
            case "O": // 원카드
                ans = size / 3;
                break;
        }

        System.out.println(ans);

    }
}
