package solution;

import java.util.*;
import java.io.*;

public class BOJ1969_DNA {

    static final char[] ACGT = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] dna = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                dna[i][j] = input.charAt(j);
            }
        }
        StringBuilder ans = new StringBuilder();
        int hdCnt = 0;
        for (int i = 0; i < M; i++) {
            int[] sameCnt = new int[26];
            for (int j = 0; j < N; j++) {
                sameCnt[dna[j][i] - 'A']++;
            }
            int maxCnt = 0;
            char maxChar = 'A';
            for(char c : ACGT) {
                if(sameCnt[c - 'A'] > maxCnt) {
                    maxCnt = sameCnt[c - 'A'];
                    maxChar = c;
                }
            }
            for(char c : ACGT) {
                if(maxChar != c) hdCnt += sameCnt[c - 'A'];
            }
            ans.append(maxChar);
        }
        System.out.println(ans);
        System.out.println(hdCnt);
    }
}
