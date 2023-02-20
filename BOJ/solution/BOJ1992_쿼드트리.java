/* [BOJ]1992. 쿼드트리
 * 쪼개고 쪼개서 봐야할 것 같음 -> 분할정복? 
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992_쿼드트리 {
	static int N, cnt0, cnt1; //2의 제곱수
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}		
		cut(0,0,N);
		System.out.println(sb);
		
		
	}

	private static void cut(int r, int c, int size) {
		
		int sum = 0;    //영상인 구간 개수
		for (int i = r, rEnd = r+size; i < rEnd; i++) {
			for (int j = c, cEnd = c+size; j < cEnd; j++) {
				sum += map[i][j];
			}
		}

		//모든 구간이 1일 때 -> 1을 출력
		if(sum == size * size) {
			sb.append(1);
			

		//모든 구간이 0 일때 -> 0을 출력
		} else if( sum == 0) {
			sb.append(0);
			
			
		} else {
			int half = size / 2;
			//한번 더 나눠야할 경우 괄호를 씌우고 다시 나눈다
			sb.append("(");
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			sb.append(")");
		}

	}

}
