package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603_로또 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;
        sb = new StringBuilder();
        while(!(input = br.readLine()).equals("0")) {
            st = new StringTokenizer(input);
            int k = Integer.parseInt(st.nextToken());
            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            // 조합
            comb(new int[6], S, 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void comb(int[] sel, int[] origin, int originIdx, int selectedIdx) {

        if(selectedIdx == sel.length) {
            for(int n : sel) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = originIdx; i < origin.length; i++) {
            sel[selectedIdx] = origin[i];
            comb(sel, origin, i+1, selectedIdx+1);
        }
    }
}
