package solution;

import java.util.*;
import java.io.*;

public class BOJ11728_배열합치기 {

    static int n, m;
    static int[] arrA, arrB;
    static List<Integer> combineArr;

    private static void combine() {
        int idx1 = 0, idx2 = 0;
        while(true) {
            int val1 = arrA[idx1], val2 = arrB[idx2];
            if(val1 <= val2) {
                combineArr.add(val1);
                idx1++;
            } else {
                combineArr.add(val2);
                idx2++;
            }
            if(idx1 == n) {
                for(int i = idx2; i < m; i++) {
                    combineArr.add(arrB[i]);
                }
                return;
            }
            if(idx2 == m) {
                for(int i = idx1; i < n; i++) {
                    combineArr.add(arrA[i]);
                }
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        combineArr = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrA = new int[n];
        arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        combine();

        StringBuilder ans = new StringBuilder();
        for(int i : combineArr) {
            ans.append(i).append(" ");
        }
        System.out.println(ans);

    }
}
