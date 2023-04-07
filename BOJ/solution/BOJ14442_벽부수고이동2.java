//[BOJ]14442.벽부수고이동2 - BFS 
package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ14442_벽부수고이동2 {

	static class Pos {
		int r,c,k,cnt;

		public Pos(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
		
	}
	static int N,M,K,res=-1;
	static int[][] map;
	static boolean[][][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		//벽을 k개 까지 부술수 있다 -> 3차원 방문배열 
		//부수고 이동하는 경우와 그렇지 않고 이동하는 경우를 나눠서 큐에 넣자
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map =  new int[N][M];
		v = new boolean[N][M][K+1];	//3차원: 0은 벽안부수고 이동, 1은 1한번부수고 이동, ....
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j <M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		res = bfs();
		System.out.println(res);
		
		
		

	}
	private static int bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0, 0, 1));	// 첫칸도 카운팅
		v[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.r==N-1 && p.c==M-1) {
				return p.cnt;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				int nk = p.k;
				
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				//다음이 0이면 그냥 이동
				if(map[nr][nc] == 0 && !v[nr][nc][nk]) {
					q.add(new Pos(nr,nc,nk,p.cnt+1));
					v[nr][nc][nk] = true;
				}
				//다음이 1인데 벽을 부술 수 있으면 부수고 이동한다
				if(map[nr][nc] == 1 && nk + 1 <= K && !v[nr][nc][nk+1]) {
					q.add(new Pos(nr,nc,nk+1,p.cnt+1));
					v[nr][nc][nk+1] = true;
				}
				
			}
		}
		return -1;
	}

}
