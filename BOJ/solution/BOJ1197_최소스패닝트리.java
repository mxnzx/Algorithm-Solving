package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


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
	static int[] dist;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		//인접리스트 생성
		adjList = new ArrayList[V+1];
		for (int i = 1; i <= adjList.length; i++) {
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
		dist = new int[V+1];
		//1. 정점배열값을 무한대로
		Arrays.fill(dist, Integer.MAX_VALUE);
		//방문배열
		v = new boolean[V];

		//2. 임의의 정점 선택
		dist[0] = 0;
		//3. 선택한 정점과 인접한 정점들의 값을 찾아 정점배열에 업뎃한다 => V-1번
		for (int i = 0; i < V-1; i++) {
			//방문하지 않은 정점 중에서 최소비용 정점을 찾는다
			int minIdx = -1;
			int minDist = Integer.MAX_VALUE;
		}
		
		
		
		System.out.println(sum);

	}

	
}
