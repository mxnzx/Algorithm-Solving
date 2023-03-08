package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 많은 전원을 연결하는 게 우선 - 전부다 찾아가면서 연결한다
 */
public class SWEA1767_프로세서연결하기 {
	static class Point {
		int r,c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	static int T,N,min;
	static int[][] map, dist;
	static boolean[] v;
	static ArrayList<Point> core = new ArrayList<>();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T=Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = br.readLine().charAt(0) - '0';
			map = new int[N][N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1 && i>0 && i<N-1 && j>0 && j<N-1) {
						//테두리에 있는 애들은 코어리스트에서 제외한다.
						core.add(new Point(i,j));
					}
				}
			}
			v = new boolean[core.size()];
			//M개 중에서 M개를 뽑는 조합부터 시작해 ~0개를 뽑는 경우까지 생각 = 이때 뽑는 개수를 R
			//DFS를 사용해 전선을 만들수 있는지 먼저 판단
				//만들수 있으면 넘기고 최종적으로 다 되었으면 결과값 갱신
				//만들 수 없으면 DFS를 빠져나오고 다음 조합으로 넘긴다
					//R개를 뽑는 모든 조합에 대해 전선을 만들지 못하는 경우가 나와 최솟값 갱신이 안된다면 R개의 코어를 사용할 수 없다
					//사용할 수 있는 Core의 최대 개수를 R-1개를 뽑는 조합으로 넘긴다.

			for (int i = core.size(); i > 0; i--) {
				comb(0,0,i);
				if(min < Integer.MAX_VALUE) break;	
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);

	}
	//중복 조합
	private static void comb(int idx, int k, int R) {
		if(k == R) {
			//중복조합이 다 뽑혔으면 dfs를 통해 전선을 만들 수 있는지 판단한다
			dfs(0,0);
			return;
		}
		for (int i = idx; i < core.size(); i++) {
			v[i] = true;
			comb(i+1, k+1, R);
			v[i] = false;
			
		}
		
	}

	//idx: 코어리스트에서 현재 해당 코어의 인덱스.    cnt: 전선 개수
	private static void dfs(int idx, int cnt) {
		
		
		for (int d = 0; d < 4; d++) {
			int r = core.get(idx).r;
			int c = core.get(idx).c;
			int tmp = 0;		//전선 길이 합 관리 변수
			
			boolean flag = false;
			while(true) {
				r += dr[d];
				c += dc[d];
				if(r<0 || r>=N || c<0 || c>=N) {	//가장가지까지 갔다면 성공
					flag = true;
					break;
					
				}
				if(map[r][c] != 0) break;	//전선(2), 코어(1)를 만나면 실패 -> 탈출
				map[r][c] = 2;
				tmp++; //전선 길이 합
			}
			//성공했다면, 다음 코어의 dfs 실시
			if(flag) dfs(idx+1, cnt+tmp);
			//원상복구 -> 이건 첨부터 nr,nc써주면 할 필요없음 (전선 돌려놔야되네 .. -> 실패했을 때 다음 조합으로 넘길때 해줄 처리
			while(true) {	
				r -= dr[d];
				c -= dc[d];
				if(r == core.get(idx).r && c == core.get(idx).c) break;
				map[r][c] = 0;		//전선 돌려놓기
			}
		}
		
		
	}
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);

			}
			System.out.println();
		}
	}

}
