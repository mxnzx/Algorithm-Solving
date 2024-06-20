package solution;

import java.util.*;
import java.io.*;

public class BOJ20437_문자열게임2 {
    static final int MAX_INF = Integer.MAX_VALUE, MIN_INF = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            char[] W = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            // 어떤 문자 K개를 정확히 포함하는 짧은 연속 문자열 + 첫번째와 마지막 글자가 같은 가장 긴 연속 문자열
            List<Integer>[] alphabets = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                alphabets[i] = new ArrayList<>();
            }
            for (int i = 0; i < W.length; i++) {
                alphabets[W[i] - 'a'].add(i);
            }

            int minLength = MAX_INF;
            int maxLength = MIN_INF;
            boolean isSeq = false;
            for (int i = 0; i < 26; i++) {
                if(alphabets[i].size() < K) continue;

                List<Integer> now = alphabets[i];
                for (int start = 0, end = K - 1; end < now.size(); start++, end++) {
                    int tmp = now.get(end) - now.get(start) + 1;
                    minLength = Math.min(tmp, minLength);
                    maxLength = Math.max(tmp, maxLength);
                    isSeq = true;
                }
            }

            if(!isSeq) {
                ans.append(-1).append("\n");
                continue;
            }
            ans.append(minLength).append(" ");
            ans.append(maxLength).append("\n");
        }
        System.out.println(ans);
    }
}
