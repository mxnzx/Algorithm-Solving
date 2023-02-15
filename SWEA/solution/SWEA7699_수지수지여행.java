/*
 * [SWEA]7699. 수지의 수지 맞는 여행
 * 모든 경우의 수를 다 따져야 함 -> 완탐 -> DFS
 * 몰랐던 문법: 클래스 멤버변수(필드 변수)는 초기화 해주지 않아도 자동으로 초기화 됨..... max를 초기화 안했었음. -> max값 계속 증가 -> 테케 오답
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA7699_수지수지여행 {

	static int T, R, C, cnt, max;
	static char[][] map;
	static int[] alphabet;
	static boolean[][] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			cnt = 0;
			max = 0;
			
			map = new char[R][C];
			alphabet = new int[26]; 		//알파벳이 나오면 -> 그 값을 1로 바꿔줌 isVisted[0]='A'이다.
			isVisited = new boolean[R][C];
			
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			//처음갈때 바꿔주고 간다
			isVisited[0][0]=true;
			alphabet[map[0][0] - 'A']++;
			dfs(0,0,1);
			
			//명물 개수 출력.
			sb.append("#" + tc + " " + max + "\n");
			
		}
		System.out.println(sb);
	}
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	/*
	 * r,c=들어온 좌표
	 * cnt = 본 명물 개수
	 */
	private static void dfs(int r,int c, int cnt) {

		//inductive part
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			//가장자리 조건과 방문한 적 없음을 만족하면
			if(nr>=0 && nr<R && nc>=0 && nc<C && !isVisited[nr][nc]) {
				//체크할 알파벳 배열 인덱스
				int aIdx = map[nr][nc]-'A';
				//알파벳을 가본적이 없다면 (= alphabet인덱스가 0이라면
				if(alphabet[aIdx] == 0) {
					isVisited[nr][nc] = true;
					alphabet[aIdx]++;
					dfs(nr, nc,cnt+1);
					isVisited[nr][nc]=false;
					alphabet[aIdx]--;
				}
				
			}
		}
		//dfs한번 돌때마다 max값 비교 후 갱신
		max = max < cnt ? cnt : max;
				
		
	}

}
