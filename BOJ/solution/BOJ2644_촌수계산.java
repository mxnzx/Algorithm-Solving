/*
 * [BOJ]2644. 촌수계산
 * bfs - 시작점~목적지 최단 거리 구하기
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ2644_촌수계산 {
	static class Vertex {
		int ver, cnt;

		public Vertex(int ver, int cnt) {
			super();
			this.ver = ver;
			this.cnt = cnt;
		}
		
	}
	static int n,m,start,end;
	static ArrayList<Integer>[] adjList;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());	//정점수
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());	//간선 수
		v=new boolean[n+1];
		adjList = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from,to;
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Vertex> q = new LinkedList<>();
		q.add(new Vertex(start, 0));
		v[start]=true;
		boolean flag=false;	//도착점에 도착 여부 flag

		while(!q.isEmpty()) {
			Vertex p = q.poll();

			if(p.ver == end) {
				flag=true;
				return p.cnt;
			}
			for(int next:adjList[p.ver]) {
				if(!v[next]){
					v[next]=true;
					q.add(new Vertex(next, p.cnt+1));
				}
			}		
		}
		if(!flag) return -1;

		return 0;
	}
	

}
