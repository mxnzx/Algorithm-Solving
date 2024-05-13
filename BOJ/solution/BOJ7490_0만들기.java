package solution;

import java.util.*;
import java.io.*;

public class BOJ7490_0만들기 {

    static int N;
    static StringBuilder ans = new StringBuilder();

    static void makeZero(int idx, int num, int sum, int op, String exp) {
        if(idx == N) {
            sum += (num*op);
            if(sum == 0) ans.append(exp).append("\n");
            return;
        }

        makeZero(idx + 1, num*10+(idx+1), sum, op, exp + " " + (idx+1));
        makeZero(idx + 1, idx+1, sum+(num*op), 1, exp + "+" + (idx+1));
        makeZero(idx + 1, idx+1, sum+(num*op), -1, exp + "-" + (idx+1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            makeZero(1,1,0,1, "1");
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
