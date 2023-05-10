package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_15686 {
    static int N, M, res, answer;
    static ArrayList<Point> houses, chickens;
    static boolean[] chickenVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집 최대 수

        int[][] arr = new int[N][N];
        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        // arr 배열에 할당
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 집, 치킨집 좌표 -> 각 arraylist에 저장
                if (arr[i][j] == 1) {
                    houses.add(new Point(i + 1, j + 1));
                } else if (arr[i][j] == 2) {
                    chickens.add(new Point(i + 1, j + 1));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        chickenVisited = new boolean[chickens.size()];
        backtracking(0, 0);
        System.out.println(answer);

    }

    public static void backtracking(int count, int start) {
        if (count == M) {
            res = 0; // 치킨 거리 합
            for (int i = 0; i < houses.size(); i++) {
                int min = Integer.MAX_VALUE; // 치킨집과의 거리
                for (int j = 0; j < chickens.size(); j++) {
                    if (chickenVisited[j] == true) {
                        int distance = Math.abs(houses.get(i).x - chickens.get(j).x)
                                + Math.abs(houses.get(i).y - chickens.get(j).y);
                        min = Math.min(min, distance);
                    }
                }
                res += min;
            }
            answer = Math.min(res, answer);
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            if (chickenVisited[i] == false) {
                chickenVisited[i] = true;
                backtracking(count + 1, i + 1);
                chickenVisited[i] = false;
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}