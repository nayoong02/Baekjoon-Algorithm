package Sorting;

import java.util.*;

class Main_10814 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<User> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int age = scan.nextInt();
            String name = scan.next();

            list.add(new User(age, name)); // User 객체 생성 -> list에 add
        }
        Collections.sort(list);

        for (User u : list) {
            System.out.println(u.age + " " + u.name);
        }
    }

    static class User implements Comparable<User> {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int compareTo(User o) { // 나이 기준 오름차순 정렬
            if (this.age < o.age) {
                return -1;
            } else if (this.age > o.age) {
                return 1;
            } else { // 나이 같을 땐 어차피 자리 변경 X -> 가입일 기준 오름차순 만족
                return 0;
            }
        }
    }

}
