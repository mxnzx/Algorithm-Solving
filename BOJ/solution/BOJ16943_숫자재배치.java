package solution;

import java.util.*;
import java.io.*;

public class BOJ16943_숫자재배치 {

    static String A;
    static int B;
    static int ans = -1;
    static char[] arr;

    static void solution(int p, char[] pick, boolean[] visited) {

        if(pick[0] == '0') return;

        if(p == pick.length) {
            int tmp = Integer.parseInt(String.valueOf(pick));
            if(tmp < B) ans = Math.max(ans, tmp);
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            pick[p] = arr[i];
            visited[i] = true;
            solution(p+1, pick, visited);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        arr = A.toCharArray();

        solution(0, new char[arr.length], new boolean[arr.length]);

        System.out.println(ans);
    }
}
