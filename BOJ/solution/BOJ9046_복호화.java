package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9046_복호화 {
    static int[] alpabet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            alpabet = new int[26];
            String str = br.readLine();
            str = str.replace(" ","");

            int maxValue = -1;
            for (int i = 0; i < str.length(); i++) {
                alpabet[str.charAt(i)-'a']++;
                maxValue = Math.max(alpabet[str.charAt(i)-'a'], maxValue);
            }
            int maxValueCnt=0;
            int maxValueIndex=0;

            for (int i = 0; i < 26; i++) {
                if(alpabet[i] == maxValue) {
                    maxValueIndex = i;
                    maxValueCnt++;
                }
            }
            sb.append(maxValueCnt == 1 ? (char) (maxValueIndex + 'a') : "?").append("\n");
        }
        System.out.println(sb);
    }
}
