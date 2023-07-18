package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11365_밀비급일 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String str;
        while(!(str = br.readLine()).equals("END")) {
            //solution(str);
            solution2(str);
        }
        System.out.println(sb);
    }

    private static void solution2(String str) {
        StringBuilder target = new StringBuilder(str).reverse();
        sb.append(target).append("\n");
    }

    private static void solution(String str) {
        char[] strArray = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(strArray[i]);
        }
        sb.append("\n");
    }
}
