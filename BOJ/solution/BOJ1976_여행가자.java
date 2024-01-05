package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976_여행가자 {
    static int N, M;
    static int[] travelRoot, parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        travelRoot = new int[M];
        parents = new int[N+1];
        // union-find 로 다 묶고나서, 주어진 여행경로들의 부모노드가 전부 일치하면 서로 이어져 있는것이다.
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1 && find(i) != find(j)) {
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            travelRoot[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M - 1; i++) {
            if(parents[travelRoot[i]] != parents[travelRoot[i+1]]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        // 작은 원소부터 탐색하므로 더 작은 원소로 바꾼다
        if(pa > pb) parents[pa] = pb;
        if(pa < pb) parents[pb] = pa;
    }

    private static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}
