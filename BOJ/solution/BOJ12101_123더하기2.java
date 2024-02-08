package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12101_123더하기2 {
    static int n, k;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());    //합
        k = Integer.parseInt(st.nextToken());    //순서

        func(0,0, new ArrayList<>());
        System.out.println(-1);
    }

    private static void func(int idx, int sum, List<Integer> arr) {

        if(sum >= n) {
            if(sum == n) {
                if(order == k) {
                    print(arr);
                    System.exit(0);
                }
                order++;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            arr.add(i);
            func(idx+1, sum+i, arr);
            arr.remove(idx);
        }
    }

    private static void print(List<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(n).append("+");
        }
        System.out.println(sb.delete(sb.length()-1, sb.length()));
    }
}
