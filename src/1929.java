import java.util.Scanner;

class Main_1929{
    static int start, end;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        start = Integer.parseInt(scan.next());
        end = Integer.parseInt(scan.next());

        for(int num = start; num <= end; num++){
            isPrime(num);
        }

    }

    public static void isPrime(int num){
        if(num < 2){
            return;
        } else if (num == 2) {
            System.out.println(num);
        } else {
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0){
                    return;
                }
            }
            System.out.println(num);
        }

    }
}