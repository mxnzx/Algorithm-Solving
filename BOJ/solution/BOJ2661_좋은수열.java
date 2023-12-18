package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2661_좋은수열 {
    private static int N;
    private static final int start = 1;
    private static final int end = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backtracking("");
    }

    private static void backtracking(String str) {
        if(str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }
        for (int i = start; i <= end; i++) {
            if(canMakeString(str+i)) backtracking(str+i);
        }
    }

    private static boolean canMakeString(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - 2*i, str.length() -i);
            String back = str.substring(str.length() - i);
            if(front.equals(back)) return false;
        }
        return true;
    }

}
