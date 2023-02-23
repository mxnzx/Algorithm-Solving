package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import sun.awt.util.IdentityLinkedList;

public class BOJ2206_벽부수고이동하기_3차원배열 {
	static class Loc{
		int r;
		int c;
		int cnt;
		int puk;
		
		public Loc(int r, int c, int cnt, int puk) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.puk = puk;
		}
		
	}

	static int N, M, Ans;
	static int[][] map;
	static boolean[][][] v; // 방문배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M][2];		//맨 뒤: 같은 위치여도 부수고 왔는지 안부수고 왔는지 구분하기 위한 구분자
		Ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		// 0이 이동 가능 1이 벽
		// 최단경로? BFS?
		// 중간에 벽 하나 부실 수 있다 -> 뭘 부실래? 몰라 ! 하나씩 다 해봐 -> DFS? -> 시간초과뜸
		bfs();

	}
	
	//방문배열을 3차원으로 준다 -> 벽을 부수었을때와 아닐때를 다른 방문배열을 사용한다
	private static void bfs() {
		 Queue<Loc> q = new LinkedList<>();
		 //0,0부터
		 //카운트는 처음부터 1
		//벽 안부셨으면 0 아니면 1
		 q.offer(new Loc(0, 0, 1, 0));		
		 
		 while(!q.isEmpty()) {
			 Loc now = q.poll();
			 
			 //도착했다면 카운트 출력
			 //BFS는 제일 먼저 도착한게 최단거리
			 if(now.r == N-1 && now.c == M-1) {
				 System.out.println(now.cnt);
				 return;
			 }
			 
			 for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				int npuk = now.puk;
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				//벽을 안부수고 길로 가는 경우
				if(map[nr][nc] == 0 && !v[nr][nc][npuk]) {   //길일 경우
					v[nr][nc][npuk] = true;
					q.offer(new Loc(nr,nc,now.cnt+1,npuk));
				}

				//벽을 부수고 가는 경우
				else if(map[nr][nc] == 1 && npuk==0) {
					v[nr][nc][1]= true;
					q.offer(new Loc(nr,nc,now.cnt+1,1));
				}
				
			}

		 }

	}
	

	

}
