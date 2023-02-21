package solution;

import java.util.Scanner;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class BOJ9663_NQueen {
	
	static int N;
	static int[][] map;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		solve(0);

	}
	//Queen:1, blank: 0
	private static void solve(int r) {
		
		//basis part
		if(r==N) {
			print(map);
		}
		
		
		//inductive part
		for (int c = 0; c < N; c++) {
			if(check(r,c)) {
				map[r][c] = 1;
				solve(r+1);
				map[r][c] = 0;
				
			}
		}
		
		
	}
	//r,c 위치에 퀸을 놓는 시점에 검사해야 하는 방향은
	//상, 좌상, 우상 을 검사해야함. 퀸을 놓는 시점이므로 그 전에것을 확인해야지 
	//퀸이 있으면 false 없으면 true
 	private static boolean check(int r, int c) {

 		
		return false;
	}
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	

}
