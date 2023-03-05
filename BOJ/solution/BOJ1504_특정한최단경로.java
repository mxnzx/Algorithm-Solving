/*
 * [BOJ]1504. 특정한최단경로
 * 다익스트라 - 꼭 거쳐야 하는 경로가 있다? -> 쪼개서 생각한다
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1504_특정한최단경로 {
	static class Node {
		int e,c;

		public Node(int e, int c) {
			this.e = e;
			this.c = c;
		}

		public int getC() {
			return c;
		}
	}
	static int N, E, u, v, Ans=Integer.MAX_VALUE;
	static ArrayList<Node>[] adjList;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[N + 1];

		// 인접 리스트 생성
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new Node(b,c));
			adjList[b].add(new Node(a,c));
		}

		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		//반복문에서 기준으로 인덱스를 쓰기 위함
		int[][] arr = {{1,u,v,N},{1,v,u,N}};

		//총 2번의 경우를 실행한다 (1 u v N / 1 v u N)
		for (int i = 0; i < 2; i++) {
			//각각의 경우에서 총 3번의 다익스트라가 실행된다
			int[] tmp = {0,0,0,0};	//임시 도착지점마다의 최단경로 저장 배열
			for (int j = 0; j < 3; j++) {
				//기존 다익스트라와 동일한 코드
				Arrays.fill(dist, Integer.MAX_VALUE);
				dist[arr[i][j]]=0;
				visited = new boolean[N+1];	//매번초기화

				PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getC));
				q.add(new Node(arr[i][j],tmp[j]));
				while (!q.isEmpty()) {
					Node p = q.poll();
					int minIdx = p.e;
					int minDist = p.c;
					visited[minIdx] = true;

					//목표노드까지 왔으면 tmp에 최단경로를 넣고 나온다
					if(minIdx == arr[i][j+1]) {
						tmp[j+1] = minDist;
						break;
					}

					for(Node next : adjList[minIdx]) {
						if(!visited[next.e] && dist[next.e] > minDist + next.c) {
							dist[next.e] = minDist + next.c;
							q.add(new Node(next.e, dist[next.e]));
						}
					}

				}
				//System.out.println(Arrays.toString(tmp));
			}
			Ans = Math.min(Ans, tmp[3]);
		}
		if(Ans == 0) System.out.println(-1);
		else System.out.println(Ans);

	}

}
