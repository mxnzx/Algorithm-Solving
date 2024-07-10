package solution;

import java.util.*;
import java.io.*;

public class BOJ1202_보석도둑 {
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            // 무게 오름차순, 값 내림차순
            if (this.weight == o.weight) return o.value - this.value;
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] bags = new int[k];
        Jewel[] jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(w, v);
        }
        Arrays.sort(jewels);
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        long ans = 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < k; i++) {
            while(j < n && jewels[j].weight <= bags[i]) {
                // 현재 가방 한계보다 보석 무게가 작거나 같으면 우선순위 큐에 담는다.
                pq.offer(jewels[j++].value);
            }
            // 가장 큰 값을 더한다.
            if(!pq.isEmpty()) ans += pq.poll();
        }

        System.out.println(ans);
    }
}
