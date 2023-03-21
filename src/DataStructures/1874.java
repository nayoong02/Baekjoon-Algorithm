package DataStructures;

import java.util.Scanner;
import java.util.Stack;

class Main_1874{
    public static void main(String args[]){
        StringBuffer sb = new StringBuffer(); //정답 담을 버퍼
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt(); //입력 받을 수열의 크기
        int start = 1; //기준은 1부터 시작
        Stack<Integer> stack = new Stack<>(); //1~n까지 넣을 스택

        //n번 반복
        for(int i = 0; i < size; i++){
            int input = scan.nextInt(); //수열을 이루는 수
            if(input >= start){ //입력 받은 숫자가 처음 기준보다 크면
                for(int j = start; j <= input; j++){ //input 될 때까지 push
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = input + 1; //그 다음 넣을 기준이 되는 수
            }

            else if(stack.peek() != input){ //맨 위 원소가 input과 다르다면 뒤에 탐색할 필요 없음(불가능한 경우)
                sb.setLength(0); //초기화 후 NO 삽입
                sb.append("NO");
                break;
            }

            stack.pop();
            sb.append('-').append('\n');

        }
        System.out.println(sb);
    }
}