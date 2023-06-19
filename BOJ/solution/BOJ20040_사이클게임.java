package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20040_사이클게임 {
    static int N,M, Ans;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //점의 개수 (0부터)
        M = Integer.parseInt(st.nextToken());   //게임 횟수
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        int a,b;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(union(a,b)) {
                Ans = i;
                break;
            }
        }
        System.out.println(Ans);
    }

    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return true;   //둘이 같으면 true 리턴(사이클발생)
        parents[pa] = pb;
        return false;
    }

    private static int find(int b) {
        if(parents[b] == b) return b;
        return parents[b] = find(parents[b]);
    }
}
