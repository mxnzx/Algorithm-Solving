package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ10163_색종이 {
	
	static int N;
	static int map[][] = new int[1001][1001];   //좌측 하단이 0,0     우측상단이 1001,1001
	static int paperNum[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		paperNum = new int[N+1];	//색종이 보이는 부분개수(1~)
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			int nx = p1.x + Integer.parseInt(st.nextToken());
			int ny = p1.y +Integer.parseInt(st.nextToken());
			
			//맵을 채운다. 
			for (int x = p1.x; x < nx; x++) {
				for (int y = p1.y; y < ny; y++) {
					map[x][y] = i;
				}
			}
		}

//		for (int x = 0; x < 100; x++) {
//			for (int y = 0; y < 100; y++) {
//				System.out.print(map[x][y]);
//			}
//			System.out.println();
//		}

		//N횟수만큼 맵을 돌면서 구역 개수를 세어 paperNum에 넣는다
		for (int i = 1; i <= N; i++) {
			for (int x = 0; x < 1001; x++) {
				for (int y = 0; y < 1001; y++) {
					if(map[x][y] == i) paperNum[i]++;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(paperNum[i]);
		}

	}

	private static class Point {
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
