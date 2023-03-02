/*
 * [BOJ]1753.최단경로
 * 양의 가중치 그래프의 최단경로 - 다익스트라
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753_최단경로 {
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
	static int V,E;
	static int[] dist;
	static boolean[] v;
	static ArrayList<Node>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		v = new boolean[V+1];
		//인접리스트 생성
		adjList = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			adjList[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		//다익스트라 - 우선순위큐
		//시작정점
		dist[start] = 0;
		
		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getC));
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			//기준 정점이 된다. = minIdx;
			Node p = q.poll();
			int minIdx = p.e;
			v[minIdx] = true;
			
			for(Node next: adjList[minIdx]) {
				if(!v[next.e] && dist[next.e] > dist[minIdx] + next.c ) {
					dist[next.e] = dist[minIdx] + next.c;
					q.add(new Node(next.e, dist[next.e]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(dist[i] != Integer.MAX_VALUE) sb.append(dist[i]).append("\n");
			else sb.append("INF").append("\n");
		}
		System.out.println(sb);
		
	}

}
