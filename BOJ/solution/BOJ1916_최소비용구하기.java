package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916_최소비용구하기 {
	
	static class Node {
		int e,c;

		public Node(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}

		public int getC() {
			return c;
		}
		
	}
	static int N,M,S,E;
	static int[] dist;
	static boolean[] v;
	static ArrayList<Node>[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());	//도시 개수(정점)
		M = Integer.parseInt(br.readLine());	// 버스 개수(간선)

		//인접리스트
		adjList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			adjList[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());	//시작정점
		E = Integer.parseInt(st.nextToken());	//도착정점
		
		dist = new int[N+1];
		v = new boolean[N+1];
		//다익스트라 ㄱㄱ
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[S]=0;
		
		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getC));
		q.add(new Node(S, 0));
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			int minIdx = p.e;
			int minDist = p.c;
			v[p.e] = true;
			
			if(p.e == E) {
				System.out.println(dist[E]);
				break;
			}
			
			for(Node next : adjList[minIdx]) {
				if(!v[next.e] && dist[next.e] > minDist + next.c) {
					dist[next.e] = minDist + next.c;
					q.add(new Node(next.e, dist[next.e]));
				}
			}
		}
		
	}

}
