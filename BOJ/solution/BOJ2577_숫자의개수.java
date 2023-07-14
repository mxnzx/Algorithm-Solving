package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2577_숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a,b,c;
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        int[] num = new int[10];
        char[] val = String.valueOf(a*b*c).toCharArray();
        for(char n : val) {
            num[n-'0']++;
        }
        for(int n : num) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }
}
