package solution;

import java.io.*;
import java.util.*;

public class BOJ30802_웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] tSize = new int[6];
        for (int i = 0; i < 6; i++) {
            tSize[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tCnt = 0;
        for (int i = 0; i < 6; i++) {
            tCnt += (tSize[i] / T);
            if(tSize[i] % T != 0) tCnt++;
        }

        System.out.println(tCnt);
        System.out.println(N / P + " " + N % P);

    }
}
