package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1325_효율적인해킹 {
    static int N,M,max=Integer.MIN_VALUE;
    static ArrayList<Integer>[] adjList;
    static boolean[] v;
    static HashSet<Integer> ans = new HashSet<>();  //중복 제거를 위해 셋으로 관리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N+1]; //컴퓨터 방문배열. 인덱스 1부터

        //인접리스트 생성
        adjList = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            //1->3, 2->3, 3->4, 3->5 =>
            to = Integer.parseInt(st.nextToken());
            from = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        for (int i = 1; i <= N; i++) {
            //방문처리 하고 시작
            v[i] = true;
            dfs(i,i,0);
            v[i] = false;
        }
//        Collections.sort(ans);

        for(int i : ans) {
            System.out.print(i + " ");
        }
    }


    private static void dfs(int start, int current, int depth) {
        System.out.println(start + " " + current + " "+ depth);
        //max값 갱신되면 바꿔준다.
        if(depth > max) {
            max = depth;
            ans.clear();
            ans.add(start);
        } else if(depth == max) {
            ans.add(start);
        }

        for(int next : adjList[current]) {
            if(!v[next]) {
                v[next] = true;
                dfs(start, next, depth+1);
                v[next] = false;
            }
        }
    }
}
