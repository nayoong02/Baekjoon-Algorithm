import java.util.Arrays;
import java.util.Scanner;

class Main_1759 {
    static int L;
    static int C;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        L = scan.nextInt();
        C = scan.nextInt();
        scan.nextLine();

        arr = new char[C];
        visited = new boolean[C];

        String line = scan.nextLine().replaceAll(" ","");

        // 공백 제거한 line에서 char 배열 채워넣기
        for(int i = 0; i < C; i++) {
            arr[i] = line.charAt(i);
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 조합
        combinatation(0, 0);
    }

    static void combinatation(int start, int cnt) {
        if (cnt == L) { // L만큼 조합 뽑아지면 검증 후 print
            int v = 0; // 모음 개수
            int c = 0; // 자음 개수
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < C; i++) {
                if(visited[i]) { // 방문된 문자면 조합에 뽑혀진 문자일 것이므로 검증 시작 !
                    sb.append(arr[i]);
                    if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                        v++;
                    } else {
                        c++;
                    }
                }
            }
            if (v >= 1 && c >= 2) { // 조건 만족하면 출력
                System.out.println(sb);
            }
        } else { // 백트래킹
            for (int i = start; i < C; i++) {
                visited[i] = true;
                combinatation(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}