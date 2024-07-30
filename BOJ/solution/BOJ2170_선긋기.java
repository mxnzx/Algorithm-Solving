package solution;

import java.util.*;
import java.io.*;

public class BOJ2170_선긋기 {

    static class Line implements Comparable<Line> {
        int s;
        int e;

        Line(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Line o) {
            return this.s - o.s;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int nowS = Integer.MIN_VALUE;
        int nowE = Integer.MIN_VALUE;
        int length = 0;
        Collections.sort(lines);

        for(Line line : lines) {
            if(nowE < line.s) {
                // 1. 하나도 안겹칠 때
                length += nowE - nowS;
                nowS = line.s;
                nowE = line.e;
            } else if(line.s >= nowS && line.e > nowE) {
                // 2. 반만 겹칠 때
                nowE = line.e;
            }
        }
        length += nowE - nowS;
        System.out.println(length);


    }
}
