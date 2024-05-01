package solution;

import java.io.*;
import java.util.*;

public class BOJ7795_먹을것인가먹힐것인가 {

    static int A, B;
    static int[] arrA, arrB;
    static StringBuilder ans = new StringBuilder();

    static int solution() {
        int cnt = 0;
        int idxA = A - 1;
        int idxB = B - 1;
        while(idxB >= 0 && idxA >= 0) {
            if(arrA[idxA] > arrB[idxB]) {
                //cnt 에 현재 idxB + 1 더한다
                cnt += idxB + 1;
                idxA--;
            } else {
                idxB--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arrA = new int[A];
            arrB = new int[B];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            Arrays.sort(arrB);

            ans.append(solution()).append("\n");
        }
        System.out.println(ans);
    }
}
