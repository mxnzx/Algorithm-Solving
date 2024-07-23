package solution;

import java.io.*;
import java.util.*;

public class BOJ1781_컵라면 {

    static class Problem implements Comparable<Problem> {
        int deadline;
        int cost;

        public Problem(int deadline, int cost) {
            this.deadline = deadline;
            this.cost = cost;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.deadline == o.deadline) return o.cost - this.cost;
            return this.deadline - o.deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        Problem[] problems = new Problem[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 데드라인 오름차순, 값 내림차순으로 정렬한다.
        Arrays.sort(problems);

        PriorityQueue<Integer> pq = new PriorityQueue<>();  //값 오름차순

        for (int i = 0; i < n; i++) {
            Problem p = problems[i];
            if (pq.isEmpty()) {
                pq.offer(p.cost);
                continue;
            }
            // 내가 대체할 수 있다면 pq에서 해당 요소 제거하고 나를 추가한다.
            if(pq.size() < p.deadline) {
                pq.offer(p.cost);
            } else if(pq.size() == p.deadline) { //내 마감기한 내로 일이 꽉 차있으면
                if (pq.peek() < p.cost) {
                    pq.poll();
                    pq.offer(p.cost);
                }
            }

        }
        while(!pq.isEmpty()) ans += pq.poll();

        System.out.println(ans);
    }
}
