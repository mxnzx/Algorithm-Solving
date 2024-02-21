package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20310_타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < S.length(); i++) {
            int n = S.charAt(i);
            if(n == '0') cnt0++;
            else cnt1++;
        }
        cnt0 /= 2;
        cnt1 /= 2;

        // 1은 앞에서 부터 떼고
        // 0은 뒤부터 뗀다
        // 그리디

        int tmp0 = 0, tmp1 = 0;
        int[] idxArr = new int[cnt0 + cnt1];
        int idx = 0;
        for (int i = 0; i < S.length(); i++) {
            if(tmp1 == cnt1) break;
            if(S.charAt(i) == '1') {
                idxArr[idx++] = i;
                tmp1++;
            }
        }
        for (int i = S.length()-1; i >= 0; i--) {
            if(tmp0 == cnt0) break;
            if(S.charAt(i) == '0') {
                idxArr[idx++] = i;
                tmp0++;
            }
        }

        char[] arr = S.toCharArray();
        for (int j : idxArr) {
            arr[j] = '2';
        }

        StringBuilder sb= new StringBuilder();
        for(char c : arr) {
            if(c != '2') sb.append(c);
        }
        System.out.println(sb);
    }
}
