package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7236_저수지깊이 {
	static int T, N, Ans;
	static char[][] map;
	
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			Ans = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				int n=0;
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(n);
					n+=2;
				}
			}
			//구획크기를 맞추기 위해 변수 조정
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					if (map[i][j] == 'W') {
						
						int cnt = 0; // W 개수
						
						for(int d=0; d<8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							
							//W가 몇갠지 센다
							if(map[nr][nc] == 'W') cnt++;
							
						}
						if(cnt == 0) cnt = 1;
						
						Ans = Math.max(Ans,	cnt);						
					}
				}
			}
			sb.append("#" + tc + " " + Ans + "\n");
		}
		System.out.println(sb);
		br.close();
	}

}
