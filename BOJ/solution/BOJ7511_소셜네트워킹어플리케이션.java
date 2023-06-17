package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7511_소셜네트워킹어플리케이션 {
    static int T, N,K,M;static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());    //유저 수(유저번호 0부터)
            //union-find를 위한 부모배열 생성
            parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }
            K = Integer.parseInt(br.readLine());    //관계 수
            int from, to;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                union(from, to);
            }
            M = Integer.parseInt(br.readLine());    //알아보고싶은 관계 수
            //union-find 를 통해 묶여있는지 구한다
            sb.append("Scenario ").append(t).append(":").append("\n");
            int u,v;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                if(find(u) == find(v)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa != pb) parents[pa] = pb;
    }

    private static int find(int b) {
        if(parents[b] == b) return b;
        return parents[b] = find(parents[b]);
    }
}
