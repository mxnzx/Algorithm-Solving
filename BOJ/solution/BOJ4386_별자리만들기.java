package solution;

import java.util.*;
import java.io.*;

public class BOJ4386_별자리만들기 {

    static class Star {

        int node;
        double dist;
        Star(int node, double dist) {
            this.node = node;
            this.dist = dist;
        }

        double getDist() {
            return dist;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        float[][] input = new float[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Float.parseFloat(st.nextToken());
            input[i][1] = Float.parseFloat(st.nextToken());
        }
        // 1. 모든 간선을 다 구해서 저장한다.
        List<Star>[] stars = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            stars[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                double dist = Math.sqrt(Math.pow(input[i][0] - input[j][0], 2) + Math.pow(input[i][1] - input[j][1], 2));
                stars[i].add(new Star(j, dist));
            }
        }

        // 2. MST - 프림 알고리즘을 통해 최소 간선의 합을 구한다.
        double[] dist = new double[N];
        boolean[] visited = new boolean[N];
        PriorityQueue<Star> pq = new PriorityQueue<>(Comparator.comparing(Star::getDist));
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[0] = 0;
        double sum = 0;

        pq.add(new Star(0, 0));

        while(!pq.isEmpty()) {
            Star now = pq.poll();

            if(visited[now.node]) continue;
            visited[now.node] = true;
            sum += dist[now.node];

            for(Star next : stars[now.node]) {
                if(!visited[next.node] && dist[next.node] > next.dist) {
                    dist[next.node] = next.dist;
                    pq.add(next);
                }
            }
        }

        System.out.printf("%.2f", sum);
    }
}

