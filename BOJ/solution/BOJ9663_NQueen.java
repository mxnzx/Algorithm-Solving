/*
 * [BOJ]9663. N-Queen - 백트래킹, 재귀
 * 일단 다 ~~~~ 돌아야 되는데 가지를 칠 수가 있다. 아닌 곳은 안가는 조건과 처음 시작점을 어떻게 해야할 지 많은 연습이 요구될 듯하다
 */

package solution;

import java.util.Scanner;


public class BOJ9663_NQueen {
	
	static int N, Ans;
	static int[][] map;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		solve(0);
		System.out.println(Ans);
	}

	//r: 행을 기준으로 볼거야
	private static void solve(int r) {
		
		if(r == N) {
			Ans++;
		}
		
		//한칸을 움직일 때마다 놓을거야 
		for(int c=0; c<N; c++) {
			//놓을 수 없는 체크 조건을 걸어준다
			if(check(r,c)) {
				map[r][c] = 1;	//퀸을 놓았다
				solve(r+1);
				map[r][c] = 0; //복구하고 다음으로			
			}
		}
		
	}


	private static boolean check(int r, int c) {
		
		//우리는 체크를 놓기 전에 본다
		//상 체크(같은 행)
		for (int i = r-1; i >= 0 ; i--) {
			if(map[i][c] == 1) return false;
		}	//상좌체크
		for (int i = r-1, j = c-1; i >= 0 && j>=0 ; i--, j--) {
			if(map[i][j] == 1) return false;
		}	//상우체크
		for (int i = r-1, j = c+1; i >= 0 && j < N ; i--, j++) {
			if(map[i][j] == 1) return false;
		}

		return true;
	}
	

}
