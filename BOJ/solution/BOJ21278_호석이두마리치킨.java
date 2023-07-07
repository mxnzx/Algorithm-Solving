package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21278_호석이두마리치킨 {

    static int N,M,result=Integer.MAX_VALUE;
    static ArrayList<Integer>[] adjList;
    static int[] resultNode = new int[2];
    static class Node {
        int node, cnt;
        public Node(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        //2개 뽑고 -> 완탐
        comb(1,0,new int[2]);
        System.out.println(resultNode[0] + " " + resultNode[1] + " " + result*2);

    }

    private static void comb(int idx, int k, int[] sel) {
        if(k == sel.length) {
            int tmp = calc(sel);
            if(result > tmp) {
                result = tmp;
                resultNode[0] = sel[0];
                resultNode[1] = sel[1];
            }
            return;
        }
        if(idx == adjList.length) return;
        for (int i = idx; i <= N; i++) {
            sel[k] = i;
            comb(i+1, k+1, sel);
        }
    }

    private static int calc(int[] sel) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            boolean[] v = new boolean[N+1];
            if(i == sel[0] || i == sel[1]) continue;
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(i,0));
            v[i] = true;
            while(!q.isEmpty()) {
                Node present = q.poll();
                if(present.node == sel[0] || present.node == sel[1]) {
                    sum+=present.cnt;
                    break;
                }
                for(int next : adjList[present.node]) {
                    if(!v[next]) {
                        q.add(new Node(next, present.cnt+1));
                        v[next]=true;
                    }
                }
            }
        }
        return sum;
    }
}
