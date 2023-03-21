package BinarySearch; /**이분탐색**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main_12015{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(); //부분수열 담을 리스트
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int val, left, right, mid, end;

        for(int i = 0; i < n; i++){
            val = Integer.parseInt(st.nextToken());
            end = list.size() - 1;

            if(val > list.get(end)){ //값이 리스트의 맨 끝 값보다 크면 리스트에 넣음
                list.add(val);
            }
            else { //끝값보다 작으면 리스트 안에서 이분 탐색 후 알맞은 자리에 넣음
                left = 0;
                right = end;
                while (left < right){
                    mid = (left + right) / 2;
                    if(val <= list.get(mid)){
                        right = mid;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                list.set(right, val);
            }
        }

        System.out.println(list.size() - 1);

    }
}