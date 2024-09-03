package solution;

import java.util.*;
import java.io.*;

public class BOJ1326_폴짝폴짝 {

    static class Bridge implements Comparable<Bridge> {
        int idx;
        int cnt;

        Bridge(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Bridge o) {
            if(this.cnt == o.cnt) return o.idx - this.idx;
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] bridges = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridges[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int origin = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        int ans = 0;
        boolean canJump = false;

        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        pq.add(new Bridge(origin, 0));
        boolean[] visited = new boolean[N+1];
        visited[origin] = true;

        while(!pq.isEmpty()) {

            Bridge now = pq.poll();

            if((dest - now.idx) % bridges[now.idx] == 0 || now.idx - dest % bridges[now.idx] == 0) {
                ans = (dest == now.idx) ? now.cnt : now.cnt + 1;
                canJump = true;
                break;
            }

            int right = now.idx;
            int left = now.idx;
            while(true) {
                right += bridges[now.idx];
                left -= bridges[now.idx];
                if(right > N && left < 1) break;

                if(right <= N && !visited[right]) {
                    pq.add(new Bridge(right, now.cnt + 1));
                    visited[right] = true;
                }

                if(left >= 1 && !visited[left]) {
                    pq.add(new Bridge(left, now.cnt + 1));
                    visited[left] = true;
                }

            }
        }

        System.out.println(canJump ? ans : -1);
    }
}