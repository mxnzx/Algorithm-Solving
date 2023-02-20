/* [BOJ]2630. 색종이만들기
 * 일정한 크기로 계속 나눈다 - > 분할정복 -> 재귀
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630_색종이만들기 {
	
	static int N, blueCnt=0, whiteCnt=0;
	static int[][] map;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0,0,N);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
		br.close();

	}

	//Divide and conquer
	private static void cut(int r, int c, int size) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		for (int i = r, rEnd = r+size; i < rEnd; i++) {
			for(int j = c, cEnd = c+size; j < cEnd; j++) {
				sum += map[i][j]; 
			}
		}
		
		if(sum == size*size) {
			blueCnt++;
		} else if(sum == 0) {
			whiteCnt++;
		} else {
			int half = size/2;
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			
		}

	}

}
