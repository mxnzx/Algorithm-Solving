package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11724_연결요소의개수 {

	static int N,M;
	static ArrayList<Integer>[] adjList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//정점
		M = Integer.parseInt(st.nextToken());	//간선

		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i]=i;
		}
		//연결요소의 개수? ->그래프가 몇개냐? -> bfs?
//		adjList = new ArrayList[N+1];
//		for (int i = 1; i < N+1; i++) {
//			adjList[i] = new ArrayList<>();
//		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		//그래프의 덩어리가 몇개 있느냐 - parents 가 같으면 같은 그래프
		int cnt=0;
		int[] tmp=new int[N+1];
		for (int i = 1; i <= N; i++) {
			tmp[parents[i]]++;
		}
		for (int i = 1; i <= N; i++) {
			if(tmp[i] > 0) cnt++;			
		}

		System.out.println(cnt);
		
		

	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			parents[pa] = parents[pb];
		}
	}

	private static int find(int n) {
		if(parents[n] == n) return parents[n];
		else return parents[n] = find(parents[n]);
	}

}
