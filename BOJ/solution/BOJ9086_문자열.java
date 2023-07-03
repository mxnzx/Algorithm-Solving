package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9086_문자열 {
    static int T;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            str = br.readLine();
            int length = str.length();
            sb.append(str.charAt(0)).append(str.charAt(length-1)).append("\n");
        }
        System.out.println(sb);
    }
}
