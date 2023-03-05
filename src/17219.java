import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int M = Integer.parseInt(line.split(" ")[1]);

        HashMap<String, String> map = new HashMap<>();
        String site;
        String pw;

        for(int i = 0; i < N; i++) {
            String line2 = br.readLine();
            site = line2.split(" ")[0];
            pw = line2.split(" ")[1];
            map.put(site, pw);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String line3 = br.readLine();
            sb.append(map.get(line3.split(" ")[0])).append("\n");
        }

        System.out.println(sb);

    }
}