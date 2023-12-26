package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2529_부등호 {
    static int k;
    static char[] arr;
    static boolean[] visited = new boolean[10];
    static String minAns = "9999999999", maxAns = "0000000000";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        String input = br.readLine();
        for (int i = 0; i < k; i++) {
            arr[i] = input.charAt(2*i);
        }
        solve(0,"");
        System.out.println(maxAns);
        System.out.println(minAns);
    }

    private static void solve(int idx, String str) {
        if(idx == k + 1) {
            if(minAns.compareTo(str) > 0) minAns = str;
            if(maxAns.compareTo(str) < 0) maxAns = str;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(visited[i]) continue;
            if(idx == 0 || check(str.charAt(str.length()-1), (char) (i+'0'), arr[idx-1])) {
                visited[i] = true;
                solve(idx + 1, str + i);
                visited[i] = false;
            }
        }
    }

    private static boolean check(char a, char b, char op) {
        if(op == '<') return a < b;
        return a > b;
    }
}
