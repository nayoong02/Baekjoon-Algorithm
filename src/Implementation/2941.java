package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < cro.length; i++) {
            if (line.contains(cro[i])) {
                line = line.replace(cro[i], "!");
            }
        }

        System.out.println(line.length());
    }
}
