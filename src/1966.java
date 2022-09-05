import java.util.LinkedList;
import java.util.Scanner;

class Main_1966{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = scan.nextInt(); //테스트 케이스 수

        for(int i = 0; i < t; i++){
            int n = scan.nextInt(); //문서 개수
            int m = scan.nextInt(); //궁금한 문서 인덱스
            int count = 0;

            LinkedList<int[]> queue = new LinkedList<>();
            for(int j = 0; j < n; j++){ //{초기 인덱스, 중요도}
                queue.add(new int[] {j, scan.nextInt()});
            }

            while (!queue.isEmpty()){
                int[] front = queue.poll(); //가장 첫 원소
                boolean isMax = true; //front가 가잔 큰 원소인지

                for(int k = 0; k < queue.size(); k++){
                    if(front[1] < queue.get(k)[1]){ //처음 원소의 중요도보다 높은 게 있으면
                        queue.offer(front); //첫 원소를 뒤로 이동

                        for(int l = 0; l < k; l++){
                            queue.offer(queue.poll()); //첫 원소 다음부터 큰 중요도 원소 전까지를 뒤로 이동
                        }

                        //처음 원소가 계속 같은 값으로 비교 대상이 되면 안되므로 종료 조건 필요
                        isMax = false;
                        break;
                    }
                }

                if(isMax == false){ //front가 가장 큰 원소가 아니므로 다음 반복문 진행
                    continue;
                }

                //front가 가장 큰 원소라면 count
                count++;
                if(front[0] == m){ //인덱스가 일치하면 테스트 케이스 탐색 종료
                    break;
                }
           }

            sb.append(count + "\n");
        }

        System.out.print(sb);
    }
}