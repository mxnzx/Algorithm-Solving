package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9046_복호화 {
    static int[] alpabet = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            str.replace(" ","");
            int maxValue = -1;
            for (int i = 0; i < str.length(); i++) {
                System.out.println(str.charAt(i)-'a');
                alpabet[str.charAt(i)-'a']++;
                maxValue = Math.max(alpabet[str.charAt(i)-'a'], maxValue);
            }
            int maxValueCnt=0;
            int maxValueIndex=0;
            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                if(maxValueCnt>1)  {
                    flag = true;
                    break;
                }
                if(alpabet[i] == maxValue) {
                    maxValueIndex = i;
                    maxValueCnt++;
                }
            }
            System.out.println(flag ? "?" : (char) (maxValueIndex + '0'));
        }
    }
}
