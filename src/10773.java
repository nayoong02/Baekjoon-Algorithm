import java.util.ArrayList;
import java.util.Scanner;

class Main_10773 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ans = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){
            int m = scan.nextInt();
            if(m != 0) {
                list.add(m);
            }
            else {
                list.remove(list.size() - 1);
            }

        }
        for(int j = 0; j < list.size(); j++) {
            ans += list.get(j);
        }

        System.out.println(ans);

    }

}
