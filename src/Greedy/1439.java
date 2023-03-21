package Greedy; /**그리디 알고리즘**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1439{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st_0 = new StringTokenizer(s, "1");
        StringTokenizer st_1 = new StringTokenizer(s, "0");

        System.out.println(Math.min(st_0.countTokens(), st_1.countTokens()));
    }
}