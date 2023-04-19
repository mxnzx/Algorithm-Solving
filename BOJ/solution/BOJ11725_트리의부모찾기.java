package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725_트리의부모찾기 {
    static int N;
    static ArrayList<Integer>[] adjList;
    static StringBuilder sb;
    static boolean[] v;
    static int[] res;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());    //정점

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        String str;
        int a,b;
        while ((str=br.readLine()) != null) {
            st = new StringTokenizer(str);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        v = new boolean[N+1];
        res = new int[N+1];
        bfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(res[i]).append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        v[start] = true;

        while (!q.isEmpty()) {
            int p = q.poll();

            for(int next : adjList[p]) {
                if(!v[next]) {
                    res[next] = p;    //현재 p가 다음 나(next)의 부모이므로 res배열에 p를 저장한다
                    q.add(next);
                    v[next] = true;
                }
            }
        }
    }


}
