import java.util.Scanner;

class Main_1065{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0; //한수 개수

        for(int i = 1; i <= n; i++){
            if(i <= 99){ //두자리수까지는 한수로 취급
                count++;
            }
            else { //세자리수부터는 비교 필요
                int a = Integer.parseInt(Integer.toString(i).split("")[0]);
                int b = Integer.parseInt(Integer.toString(i).split("")[1]);
                int c = Integer.parseInt(Integer.toString(i).split("")[2]);
                if((a - b) == (b - c)){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}