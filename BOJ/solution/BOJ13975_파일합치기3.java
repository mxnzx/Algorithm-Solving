package solution;

import java.util.*;
import java.io.*;

public class BOJ13975_파일합치기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long cost = 0L;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            while(pq.size() > 1) {
                long n1 = pq.poll();
                long n2 = pq.poll();
                cost += n1 + n2;
                pq.add(n1 + n2);
            }
            ans.append(cost).append("\n");
        }
        System.out.println(ans);
    }
}
