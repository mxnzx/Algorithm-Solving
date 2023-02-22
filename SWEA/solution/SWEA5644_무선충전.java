package solution;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5644_무선충전 {
	static int T, M, A, Ans;
				//   제자리 상 우 하  좌
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};
	static int[][] map = new int[10][10];	//인덱스 1부터
	static int[] userA, userB;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		System.setIn(new FileInputStream("input.txt"));
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());	// 이동시간
			A = Integer.parseInt(st.nextToken());	//BC의 개수
			Ans = Integer.MIN_VALUE;
			int[][] person = new int[2][M];

			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				person[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				person[1][i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 2; i++) {
				System.out.println(Arrays.toString(person[i]));
			}
			
			//BC정보 입력받아오면서 지도에 표시하기
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				
				Point p = new Point(y,x);	//행렬 바뀌어 들어옴
				int d = Integer.parseInt(st.nextToken());	//거리
				int power = Integer.parseInt(st.nextToken());    //성능
				//지도에 해당 충전 범위를 표시한다
				//mapping(p, d, power);
				
			}
			
			
			//A,B 동시에 출발
			//맵에 저장된 것따라 간다 
			// 
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(map[i][j] + "\t");
				}
				System.out.println();
			}
			
			
		}
		

	}
//	private static void mapping(Point p, int d, int power) {
//		
//		
//	}
	private static class Point {
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}

}
