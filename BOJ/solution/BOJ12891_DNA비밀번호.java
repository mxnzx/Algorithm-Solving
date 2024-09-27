package solution;

import java.util.*;
import java.io.*;


public class BOJ12891_DNA비밀번호 {

    static char[] acgt = {'A', 'C', 'G', 'T'};
    static int[] acgtCnt = new int[26];

    static boolean isPassword() {
        for(char c : acgt) {
            if(acgtCnt[c - 'A'] > 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String dna = br.readLine(); // length = S
        st = new StringTokenizer(br.readLine());
        for (char c : acgt) {
            acgtCnt[c - 'A']= Integer.parseInt(st.nextToken());
        }
        // sliding window
        int ans = 0;

        //맨 처음것 비교
        for (int i = 0; i < P; i++) {
            acgtCnt[dna.charAt(i) - 'A']--;
        }
        // 모두 0보다 같거나 작아야 통과
        if(isPassword()) ans++;

        for (int i = P, prev = 0; i < S; i++, prev++) {
            // 복구
            acgtCnt[dna.charAt(prev) - 'A']++;
            // 하나 추가
            acgtCnt[dna.charAt(i) - 'A']--;
            // 검사
            if(isPassword()) ans++;
        }
        System.out.println(ans);
    }
}
