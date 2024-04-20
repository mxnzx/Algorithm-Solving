package solution;

import java.util.*;
import java.io.*;

public class BOJ17952_과제는끝나지않아 {

    static class Work {

        int fullScore;
        int time;

        Work(int fullScore, int time) {
            this.fullScore = fullScore;
            this.time = time;
        }
    }

    static Stack<Work> hw;
    static int totalScore;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        hw = new Stack<>();
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            if(m == 1) {
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                hw.push(new Work(s, t));
            }
            if(!hw.isEmpty()) {
                Work now = hw.pop();
                now.time--;
                // 과제 시간이 끝났으면 hw 제외하고, 점수 획득한다.
                if(now.time == 0) {
                    totalScore += now.fullScore;
                } else {
                    hw.push(now);
                }
            }
        }
        System.out.println(totalScore);
    }
}
