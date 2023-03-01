package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ1197_최소스패닝트리 {
	public static class Vertex implements Comparable<Vertex>{
		int to;
		long weight;
		
		public Vertex(int to, long weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
	}
	
	
	static int V,E;
	static ArrayList<Vertex>[] adjList;
	static long[] dist;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		
		//인접리스트 생성
		adjList = new ArrayList[V+1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new Vertex(b, c));
			adjList[b].add(new Vertex(a, c));
		}
		
		//정점배열
		dist = new long[V+1];
		//1. 정점배열값을 무한대로
		Arrays.fill(dist, Integer.MAX_VALUE);
		//방문배열
		v = new boolean[V+1];

		//2. 임의의 정점 선택(1번부터)
		dist[1] = 0;

		//3. 비용이 최솟값인 정점을 찾기 위해 priorityQueue를 생성
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		//3-1. 시작점을 큐에 넣는다
		q.add(new Vertex(1,0));

		long sum = 0;
		//3-2. 큐가 빌때까지 하나씩 빼면서 최소 정점을 찾아 정점배열에 업뎃한다
		while(!q.isEmpty()) {
			//거리가 가장 작은 점을 poll한다
			//p: 시작정점
			Vertex p = q.poll();

			if(!v[p.to]) {
				v[p.to] = true;
				sum += p.weight;
				//ver : 도착정점
				for(Vertex ver : adjList[p.to]) {
					if(!v[ver.to] && ver.weight < dist[ver.to]) {
						dist[ver.to] = ver.weight;
						q.add(ver);
					}
				}
			}
		}

		System.out.println(sum);
	}

	
}
