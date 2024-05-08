package solution;

import java.util.*;
import java.io.*;

public class BOJ1389_케빈베이컨의6단계법칙 {
    static int N, M, sum;
    static ArrayList<Integer>[] friends;
    static int ansNum, ansValue = Integer.MAX_VALUE;

    static boolean[] visited;
    static class Node {
        int node;
        int cnt;
        Node(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }

    static void countKevinBacon(int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(target, 0));
        visited[target] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            sum += now.cnt;

            for(int next: friends[now.node]) {
                if(visited[next]) continue;
                q.add(new Node(next, now.cnt + 1));
                visited[next] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            friends[p1].add(p2);
            friends[p2].add(p1);
        }

        // 한명씩 돌아가면서 친구 수를 센다(5000) * 100 = 완탐
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            sum = 0;
            countKevinBacon(i);
            if(sum < ansValue) {
                ansNum = i;
                ansValue = sum;
            }
        }

        System.out.println(ansNum);
    }
}
