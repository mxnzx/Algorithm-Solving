//Union-find 방식
package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724_연결요소의개수 {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());    //정점
        M = Integer.parseInt(st.nextToken());    //간선

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        //그래프의 덩어리가 몇개 있느냐 - parents 가 같으면 같은 그래프
        int cnt = 0;
        int[] tmp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            //그래프가 완성된 후 현재 parents에서 한번 더 find를 해주어야 함(갱신)
            tmp[find(parents[i])]++;
        }
        for (int i = 1; i <= N; i++) {
            if (tmp[i] > 0) cnt++;
        }
        //System.out.println(Arrays.toString(tmp));
        System.out.println(cnt);


    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parents[pb] = parents[pa];
        }
    }

    private static int find(int n) {
        if (parents[n] == n) return parents[n];
        else return parents[n] = find(parents[n]);
    }

}