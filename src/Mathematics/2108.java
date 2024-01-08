package Mathematics;

import java.util.*;

class Main_2108 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(scan.nextInt());
        }
        Collections.sort(list);

        // 1. 산술평균 (소수점 이하 첫째 자리에서 반올림)
        System.out.println(avg(list));

        // 2. 중앙값
        System.out.println(mid(list));

        // 3. 최빈값 (여러 개 있으면 최빈값 중 두 번째로 작은 값)
        System.out.println(maxCount(list));

        // 4. 범위
        System.out.println(range(list));
    }

    // 1. 산술평균 (소수점 이하 첫째 자리에서 반올림)
    public static int avg(ArrayList<Integer> list) {
        int size = list.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }

        return (int) Math.round((double) sum / size);
    }

    // 2. 중앙값
    public static int mid(ArrayList<Integer> list) {
        int idx = list.size() / 2;

        return list.get(idx);
    }

    // 3. 최빈값 (여러 개 있으면 최빈값 중 두 번째로 작은 값)
    public static int maxCount(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // 원소 1개면 바로 리턴
        if (list.size() == 1) {
            return list.get(0);
        }

        // 맵에 카운트 넣기
        for (int i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxVal = Collections.max(map.values()); // 최빈값

        // 맵 돌면서 최빈값이면 리스트에 넣기
        ArrayList<Integer> keyList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == maxVal) {
                keyList.add(m.getKey());
            }
        }

        Collections.sort(keyList); // 오름차순 정렬
        if (keyList.size() > 1) { // 최빈값 2개 이상이면 두 번째로 작은 값
            return keyList.get(1);
        } else { // 최빈값 1개
            return keyList.get(0);
        }
    }

    // 4. 범위
    public static int range(ArrayList<Integer> list) {
        return list.get(list.size() - 1) - list.get(0);
    }

}
