package solution;

import java.util.*;
import java.io.*;

public class BOJ1689_겹치는선분 {

    static class Line implements Comparable<Line> {
        int node;
        int type;    // 시작(0), 끝(1)

        Line(int node, int type) {
            this.node = node;
            this.type = type;
        }

        @Override
        public int compareTo(Line o) {
            if (this.node == o.node) return o.type - this.type;
            return this.node - o.node;
        }
    }

    static final int START_TYPE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Line> lines = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines.add(new Line(Integer.parseInt(st.nextToken()), 0));
            lines.add(new Line(Integer.parseInt(st.nextToken()), 1));
        }

        int ans = 1;
        int nowCnt = 0;
        while(!lines.isEmpty()) {
            Line line = lines.poll();
            if(line.type == START_TYPE) {
                nowCnt++;
                ans = Math.max(ans, nowCnt);
            } else {
                nowCnt--;
            }
        }
        System.out.println(ans);
    }
}
