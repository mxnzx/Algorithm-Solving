package solution;

import java.util.*;
import java.io.*;

public class BOJ1038_감소하는수 {
    static int n;
    static List<Long> list = new ArrayList<>();

    static void backtracking(long num) {
        list.add(num);
        long val = num % 10;
        if(val == 0) return;

        for (long i = val - 1; i >= 0; i--) {
            long tmp = num * 10 + i;
            backtracking(tmp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // n번째 감소하는 수를 구해라.
        for (int i = 0; i < 10; i++) backtracking(i);

        Collections.sort(list);
        System.out.println(n < list.size() ? list.get(n) : -1);
    }
}
