package solution;

import java.util.*;
import java.io.*;

public class BOJ1057_토너먼트 {

    static int N, jimin, hansu;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        jimin = Integer.parseInt(st.nextToken());
        hansu = Integer.parseInt(st.nextToken());

        int round = 0;
        while(jimin != hansu) {
            round++;
            if(jimin % 2 == 0) {
                jimin /= 2;
            } else {
                jimin = jimin / 2 + 1;
            }

            if(hansu % 2 == 0) {
                hansu /= 2;
            } else {
                hansu = hansu / 2 + 1;
            }
        }
        System.out.println(round);

    }
}
