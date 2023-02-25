/*
 * [BOJ]2206. 벽부수고이동하기 - 방문배열이 3차원인 BFS
 * 막힌 과정: DFS로 풀면서 flag을 두었더니 시간초과 뜸
 * 내가 어떤 플래그를 가지고 BFS탐색을 할때에는 플래그 상태에 따라 방문처리를 다르게 해야하므로 기존의 2차원이 아닌 3차원으로 두어야 하는 문제이다.
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206_벽부수고이동하기 {
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
		 //0,0부터 시작. cnt는 1부터. 벽 안부수었으면 0
		 q.offer(new Loc(0,0,1,0));

		 while(!q.isEmpty()) {

			 Loc p = q.poll();

			 if(p.r == N-1 && p.c == M-1){
				 System.out.println(p.cnt);
				 return;
			 }

			 for (int d = 0; d < 4; d++) {
				 int nr = p.r + dr[d];
				 int nc = p.c + dc[d];
				 int npuk = p.puk;

				 if(nr<0 || nr>=N || nc<0 || nc>=M) continue;

				 //벽을 부수지 않고 이동하는 경우
				 if(map[nr][nc] == 0 && !v[nr][nc][npuk]) {
					 v[nr][nc][npuk] = true;
					 q.offer(new Loc(nr,nc,p.cnt+1,npuk));
				 }
				//벽을 부수고 이동하는 경우 v[nr][nc][npuk] 의 방문유무를 체크할 필요가 왜 없지? 어차피 1이라서 못갔을 것이기 때문에? ㅇㅇ
				 else if(map[nr][nc] == 1 && npuk == 0) { 
					 v[nr][nc][1] = true;
					 q.offer(new Loc(nr,nc,p.cnt+1,1));
				 }
			 }


		 }
		System.out.println(-1);

	}
	

	

}
