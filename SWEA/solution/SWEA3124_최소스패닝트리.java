/*
 * [SWEA]3124. 최소스패닝트리
 * MST - 크루스칼 알고리즘, 프림알고리즘
 * 놓친 부분: 테케 바뀔때 초기화 안해줌. 데이터 타입 !!!! 주의 하좌 ... 
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA3124_최소스패닝트리 {
	
	static class Vertex implements Comparable<Vertex>{
		int e;
		long c;

		public Vertex(int e, long c) {
			super();
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.c, o.c);
		}
	}
	static int T,V,E;
	static ArrayList<Vertex>[] adjList;
	static long[] dist;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			//인접리스트 구현
			adjList = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}
			//값을 넣어준다
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adjList[a].add(new Vertex(b, c));
				adjList[b].add(new Vertex(a, c));
			}
			
			//Prim
			dist = new long[V+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			v = new boolean[V+1];
			
			//0번부터 시작해보자
			dist[1] = 0;

			PriorityQueue<Vertex> q = new PriorityQueue<>();
			q.add(new Vertex(1,0));

			long sum = 0;
			while (!q.isEmpty()) {
				Vertex p = q.poll();

				if(!v[p.e]) {
					v[p.e] = true;
					sum += p.c;
					for(Vertex ver : adjList[p.e]) {
						if(!v[ver.e] && ver.c < dist[ver.e]) {
							dist[ver.e] = ver.c;
							q.add(ver);
						}
					}
				}

			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
		

	}


}
