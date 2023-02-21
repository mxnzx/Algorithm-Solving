/*
 * [BOJ]3109. 빵집 - 백트래킹
 * 놓친 부분 : 델타함수 순서가 필요할때 있음
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109_빵집 {
	static int R, C, Ans=0;
	static char[][] map;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		//행별로 생각한다 -> 일단 다 가
		for (int r = 0; r < R; r++) {
			flag = false;
			solve(r,0);

		}
		System.out.println(Ans);

	}
	// 무조건 위쪽을 먼저 향해 간다
	//                우상 우 우하
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	private static void solve(int r,int c) {

		//속도 향상
		if(flag) return;

		//basis part
		//c가 다왔으면 리턴
		if(c == C-1) {
			Ans++;
			flag = true;
			return;
		}

		//inductive part
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc] == '.' && !flag) {
				map[nr][nc] = 'x';
				//System.out.println(nr + " " + nc);
				solve(nr,nc);
			}
		}
	}

}
