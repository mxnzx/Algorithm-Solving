package solution;

import java.util.*;
import java.io.*;

public class BOJ2992_크면서작은수 {
    static int num;
    static char[] arr;

    static void backtracking(boolean[] visited, char[] pick, int p) {

        if(p == pick.length) {
            int tmp = Integer.parseInt(String.valueOf(pick));
            if (tmp > num) {
                System.out.println(tmp);
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < pick.length; i++) {
            if(visited[i]) continue;
            pick[p] = arr[i];
            visited[i] = true;
            backtracking(visited, pick, p+1);
            visited[i] = false;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        num = Integer.parseInt(X);
        arr = X.toCharArray();
        //자리수 6 > 완탐 가능
        Arrays.sort(arr);

        backtracking(new boolean[X.length()], new char[X.length()], 0);
        System.out.println(0);
    }
}
