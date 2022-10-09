import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = 0; //상근부터 시작

        while (N > 0) {
            if(N < 3) {
                N -= 1;
                index++;
            } else {
                N -= 3;
                index++;
            }
        }

        if(index % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }


    }
}