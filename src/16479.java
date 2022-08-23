import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1358{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); //등변사다리꼴 빗변
        StringTokenizer st = new StringTokenizer(br.readLine());
        double d1 = Integer.parseInt(st.nextToken()); //윗면 지름
        double d2 = Integer.parseInt(st.nextToken()); //밑면 지름

        if(d1 == d2){
            System.out.print(Math.pow(k, 2));
        }
        else {
            System.out.print(Math.pow(k, 2) - Math.pow(((d1 - d2) / 2), 2));
        }

    }
}