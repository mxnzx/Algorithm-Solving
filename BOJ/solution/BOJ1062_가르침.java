package solution;

import java.util.*;
import java.io.*;

public class BOJ1062_가르침 {

    static int n, k, maxCnt;
    static boolean[] alphabet = new boolean[26];
    static List<char[]> words;

    static void countPassWord() {
        int cnt = 0;
        for(char[] word : words) {
            boolean flag = true;
            for(char c : word) {
                if(!alphabet[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }
        maxCnt = Math.max(cnt, maxCnt);
    }

    static void pickAlphabet(int idx, int p) {
        if(p == k) {
            countPassWord();
            return;
        }

        for (int i = idx; i < 26; i++) {
            if(alphabet[i]) continue;

            alphabet[i] = true;
            pickAlphabet(i+1, p+1);
            alphabet[i] = false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(k < 5) {
            System.out.println(0);
            return;
        }
        alphabet['a'-'a'] = true;
        alphabet['c'-'a'] = true;
        alphabet['n'-'a'] = true;
        alphabet['i'-'a'] = true;
        alphabet['t'-'a'] = true;
        k -= 5;
        words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            input = input.substring(4, input.length() - 4);
            words.add(input.toCharArray());
            // 21개 중 k-5개를 뽑는다.
        }
        pickAlphabet(0,0);
        System.out.println(maxCnt);
    }
}
