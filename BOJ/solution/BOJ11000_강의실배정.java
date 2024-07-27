package solution;

import java.util.*;
import java.io.*;

public class BOJ11000_강의실배정 {
    static class Lecture implements Comparable<Lecture> {
        int s;
        int e;

        Lecture(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.e == o.e) return o.s - this.s;
            return o.e - this.e;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(lectures);

        PriorityQueue<Lecture> pq = new PriorityQueue<>((o1, o2) -> o2.s - o1.s);
        pq.add(lectures[0]);
        for (int i = 1; i < N; i++) {
            Lecture now = lectures[i];
            if(now.e <= pq.peek().s) {
                Lecture l = pq.poll();
                l.s = now.s;
                pq.add(l);
                continue;
            }
            pq.add(now);
        }
        System.out.println(pq.size());
    }
}