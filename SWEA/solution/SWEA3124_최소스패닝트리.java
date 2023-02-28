/*
 * [SWEA]3124. 최소스패닝트리
 * MST - 크루스칼 알고리즘 
 * 놓친 부분: 테케 바뀔때 초기화 안해줌. 데이터 타입 !!!! 주의 하좌 ... 
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA3124_최소스패닝트리 {
	
	static class Vertex {
		int e;
		long c;

		public Vertex(int e, long c) {
			super();
			this.e = e;
			this.c = c;
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
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<>();
			}
			//값을 넣어준다
			for (int i = 1; i <= E; i++) {
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
			dist[0] = 0;
			
			//선택한 정점과 인접한 정점들의 값을 찾아서 정점배열에 업데이트한다 => V-1번 반복한다
			for (int cnt = 0; cnt < V-1; cnt++) {
				//방문하지 않은 정점 중 최소비용의 정점을 찾는다
				int minIdx = -1;
				long minDist = Integer.MAX_VALUE;
				for (int i = 1; i <= V; i++) {
					if(!v[i] && dist[i] < minDist) {
						minIdx = i;
						minDist = dist[i];
					}
				}
				System.out.println(minIdx);
				//값이 바뀌었다면 방문처리
				v[minIdx] = true;
				
				//minIdx정점과 연결된 정점들을 찾아 업데이트 한다.
				//minIdx: 출발정점
				for(Vertex vt : adjList[minIdx]) {
					if(!v[vt.e] && vt.c < dist[vt.e]) dist[vt.e] = vt.c;
				}
				
			}
			long sum = 0;
			for(int i=1;i <= dist.length;i++) {
				sum += dist[i];
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
		

	}


}
