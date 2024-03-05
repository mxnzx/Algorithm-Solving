package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251_LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        /*
        2차원 배열을 만든 뒤, 최장길이를 담는다.
        최장길이 사이즈의 배열을 만들고, 그 안에 역순으로 따라가며 문자를 넣는다.
        그 배열의 역순이 최장공통부분수열이다.
         */
        searchLCS(str1, str2,new int[str1.length+1][str2.length+1]);

    }

    private static void searchLCS(char[] str1, char[] str2, int[][] lcs) {
        // 1. lcs 길이를 구한다
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if(str1[i-1] == str2[j-1]) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        System.out.println(lcs[str1.length][str2.length]);

//        //2. lcs 찾는다
//        int max = lcs[str1.length][str2.length];
//        char[] LCS = new char[max];
//        int idx = LCS.length - 1;
//        int r = str1.length, c = str2.length;
//        while(true) {
//            if(max == lcs[r-1][c]) {
//                r--;
//            } else if(max == lcs[r][c-1]) {
//                c--;
//            } else {
//                LCS[idx--] = str1[r-1];
//                r--;
//                c--;
//                max = lcs[r][c];
//                if(max == 0) break;
//            }
//        }
//        System.out.println(String.valueOf(LCS));

    }

}
