/*
 * [BOJ]13023. ABCDE
 * 자료구조(그래프), DFS
 * 그래프를 DFS로 탐색하는 건 정형화된 코드이므로 잘 익혀두자(DFS코드에서 for문 for-each로 쓰는게 실수 줄임)
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13023_ABCDE {
    static int N, M, Ans=0;
    static ArrayList<Integer>[] adjList;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new boolean[N];
        //인접 리스트 생성
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }
        //모든 정점에서 dfs 체크
        for (int i = 0; i < N; i++) {
            if (Ans == 0) {
                v[i] = true;
                dfs(i, 0);
                v[i] = false;

            }
        }
        System.out.println(Ans);

    }

    private static void dfs(int start, int depth) {
        //System.out.println(start + " "+ depth);
        if (depth == 4) {
            Ans = 1;
            return;
        }
        for (int next : adjList[start]) {
            //다음것으로 가는데 그전에 방문안했어야 함
            if (!v[next]) {
                v[next] = true;
                dfs(next, depth + 1);
                v[next] = false;
            }

        }

    }

}
