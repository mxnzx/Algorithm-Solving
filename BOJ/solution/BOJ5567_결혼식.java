package solution;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class BOJ5567_결혼식 {

    static int N, M;
    static ArrayList<Integer>[] adjList;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from, to;
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);

        }
        v = new boolean[N+1];
        bfs(1);
    }

    private static void bfs(int start) {
        // TODO Auto-generated method stub
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        v[start] = true;
        int cnt=0;
        int depth=0;

        while (!q.isEmpty()) {
            depth++;
            //depth가 3이면 빠져나온다(= 친구의 친구의 친구)
            if(depth >= 3) break;

            int size = q.size();
            for(int i=0;i<size;i++) {
                int p = q.poll();

                for(int next: adjList[p]) {
                    if(!v[next]) {
                        v[next] = true;
                        cnt++;
                        q.add(next);
                    }
                }
            }

        }
        System.out.println(cnt);

    }

}