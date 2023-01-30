package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int re = Integer.parseInt(st.nextToken());  //반복횟수
            String input = st.nextToken();
            for (int i = 0; i < input.length(); i++) {
                for (int j = 0; j < re; j++) {
                    sb.append(input.charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
