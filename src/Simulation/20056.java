package Simulation;

import java.io.*;
import java.util.*;

class Main_20056 {
    static int N, M, K;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Fireball>[][] fireballs;
    static ArrayList<Fireball> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        fireballs = new Queue[N][N];
        list = new ArrayList<>();

        // 2차원 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fireballs[i][j] = new LinkedList<>();
            }
        }

        int r, c, m, s, d;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            // 객체 생성 후 리스트에 삽입
            list.add(new Fireball(r, c, m, s, d));
        }

        // 명령 수 만큼 반복
        for (int i = 0; i < K; i++) {
            // d 방향으로 s 칸 만큼 이동
            moveFireballs();

            // 한 칸에 2개 이상이면 합치고 나누기
            moreThanTwo();
        }

        // 리스트에 남아있는 파이어볼의 질량 합
        int ans = 0;
        for(Fireball f : list) {
            ans += f.m;
        }

        System.out.print(ans);
    }

    // d 방향으로 s 칸 만큼 이동
    static void moveFireballs() {
        for (Fireball f : list) {
            f.x = (N + f.x + dx[f.d] * (f.s % N)) % N;
            f.y = (N + f.y + dy[f.d] * (f.s % N)) % N;

            // 큐 배열에 객체 추가
            fireballs[f.x][f.y].add(f);
        }
    }

    // 각 칸마다 탐색 -> 2개 이상이면 합치고 나누기
    static void moreThanTwo() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 칸에 2개 이상이면
                if (fireballs[i][j].size() >= 2) {
                    int totalM = 0; // 질량 합
                    int totalS = 0; // 속도 합
                    int count = fireballs[i][j].size(); // 파이어볼 개수
                    boolean even = true;
                    boolean odd = true;

                    // 파이어볼 합치고 나누기
                    while(!fireballs[i][j].isEmpty()) {
                        Fireball temp = fireballs[i][j].poll();
                        totalM += temp.m;
                        totalS += temp.s;

                        if (temp.d % 2 == 0) { // 방향이 짝수인지 체크
                            odd = false;
                        } else { // 홀수인지 체크
                            even = false;
                        }
                        list.remove(temp); // 리스트에서도 삭제
                    }

                    int dividedM = totalM / 5;
                    if (dividedM == 0) continue; // 질량 0이면 소멸

                    int dividedS = totalS / count;

                    if (even || odd) { // 다 짝수거나 홀수이면
                        for (int k = 0; k <= 6; k += 2) { // 방향 0, 2, 4, 6
                            list.add(new Fireball(i, j, dividedM, dividedS, k));
                        }
                    } else { // 아니면
                        for (int k = 1; k <= 7; k += 2) { // 방향 1, 3, 5, 7
                            list.add(new Fireball(i, j, dividedM, dividedS, k));
                        }
                    }
                }
                else { // 2개 이상이 아니면 합칠 일 없으니까 큐에선 지우기
                    fireballs[i][j].clear();
                }

            }
        }
    }

    static class Fireball {
        int x;
        int y;
        int m;
        int s;
        int d;

        public Fireball(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

}
