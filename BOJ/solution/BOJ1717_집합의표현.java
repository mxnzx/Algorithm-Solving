package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1717_집합의표현 {

    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 분리집합 - Union Find
        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                // Union
                union(a, b);
                System.out.println(Arrays.toString(parents));
            } else {
                if(find(a) == find(b)) answer.append("YES");
                else answer.append("NO");
                answer.append("\n");
            }
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return;
        if(pa > pb) {
            parents[pa] = pb;
        } else {
            parents[pb] = pa;
        }
    }

    private static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}
