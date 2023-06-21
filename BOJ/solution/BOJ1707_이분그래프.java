package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707_이분그래프 {

    static int K, V, E;
    static ArrayList<Integer>[] adjList;
    static boolean[][] binaryGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());    //테케
        for (int testCase = 0; testCase < K; testCase++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[V+1];
            for (int i = 1; i <= V; i++) {
                adjList[i] = new ArrayList<>();
            }
            int from, to;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
                adjList[to].add(from);
            }
            // ====== input 완료 =========
            binaryGraph = new boolean[V+1][2];  //2차원은 check 배열
            boolean isBinaryGragh = true;
            for (int i = 1; i <= V; i++) {
                if(!binaryGraph[i][1]) {
                    isBinaryGragh = bfs(i);
                    if(!isBinaryGragh) break;
                }
            }
            String result = isBinaryGragh ? "YES" : "NO";
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    private static boolean bfs(int startVertex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startVertex);
        binaryGraph[startVertex][0] = true;     //한 집합의 시작정점은 무조건 true 그룹에 둠
        binaryGraph[startVertex][1] = true;     //방문체크

        while (!q.isEmpty()) {
             int present = q.poll();
             boolean presentVertexGroup =  binaryGraph[present][0];
             for(int next : adjList[present]) {
                 //다음 정점이 이미 방문을 했던 상태인데 현재 정점과 같은 그룹에 속했으면 진행 중단
                 if(binaryGraph[next][1]) {
                     if(binaryGraph[next][0] != presentVertexGroup) continue;
                     return false;
                 }
                 binaryGraph[next][0] = !presentVertexGroup;
                 binaryGraph[next][1] = true;
                 q.add(next);
             }
        }
        return true;
    }
}
