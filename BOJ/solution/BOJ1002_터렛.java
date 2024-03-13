package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1002_터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            double d = Math.sqrt((int) Math.pow(Math.abs(x2 - x1), 2) + (int) Math.pow(Math.abs(y2 - y1), 2));

            if (r1 == r2) {
                if (d == 0) answer.append(-1);
                else {
                    if (d > r1 + r2) answer.append(0);
                    else if (d == r1 + r2) answer.append(1);
                    else answer.append(2);
                }
            } else {
                if (Math.abs(r1-r2)> d || d > r1 + r2) answer.append(0);
                else if (d == r1 + r2 || Math.abs(r1 - r2) == d) answer.append(1);
                else answer.append(2);
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
