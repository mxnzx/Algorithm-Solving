package solution;

import java.io.*;
import java.util.*;

public class BOJ6443_애너그램 {

    static int N;
    static StringBuilder ans = new StringBuilder();
    static void comb(char[] input, String now, int idx, boolean[] visited) {

        if(idx == input.length) {
            ans.append(now).append("\n");
            return;
        }

        char past = '*';
        for (int i = 0; i < input.length; i++) {
            char current = input[i];
            if(!visited[i] && past != current) {
                visited[i] = true;
                past = current;
                comb(input, now + input[i], idx + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            Arrays.sort(input);
            comb(input, "", 0, new boolean[input.length]);
        }
        System.out.println(ans);
    }
}
