/*
 * [SWEA]5656.벽돌깨기
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5656_벽돌깨기 {

	static int T, N, W, H;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//구슬 개수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//구슬을 놓을 열 3개를 뽑는다. 중복 가능. 순서 있음 => 중복순열
			perm(new int[N],0);

		}

	}
	private static void perm(int[] sel, int k) {
		if(k == N) {
			//System.out.println(Arrays.toString(sel));
			breakBrick(sel);
			return;
		}
		
		for (int i = 0; i < W; i++) {
			sel[k] = i;
			perm(sel, k+1);
		}
		
	}
	
	//깰때마다 수를 센다 -> 한 세트 완료했으면 비교 후 갱신
	private static void breakBrick(int[] sel) {
		
		//첫번째 구슬 떨어진 위치의 맵의 값을 찾는다
		for (int cnt = 0; cnt < N; cnt++) {
			int r = 0;
			int c = sel[cnt];
			for (int i = 0; i < H; i++) {
				if(map[i][c] != 0) {
					r = i;
					break;
				}
				//r의 값이 0이라면(=해당 열에 값이 없다면) 리턴
				if(r==0) return;
				
				
			}
			
			
		}
	
		
		
	}
	private static void print(int[][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
