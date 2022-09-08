import java.util.ArrayList;
import java.util.Scanner;

class Main_1427{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        String line = scan.next();
        for(int i = 0; i < line.length(); i++){
            list.add(Integer.parseInt(String.valueOf(line.charAt(i))));
        }
        list.sort(null);

        for(int i = list.size() - 1; i >= 0; i--){
            System.out.print(list.get(i));
        }
    }
}