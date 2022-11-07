import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        BigInteger A = new BigInteger(line.split(" ")[0]);
        BigInteger B = new BigInteger(line.split(" ")[1]);

        System.out.println(A.add(B));


    }
}