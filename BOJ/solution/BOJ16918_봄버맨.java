package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16918_봄버맨 {

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}

	}
	static int R, C, N;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = {0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'O') map[i][j] = 3+'0';
			}
		}

		// time==0 -> 초기 폭탄 설치. 변화없음
		// time==1 -> 변화없음
		// time==2 -> 나머지칸에 폭탄 설치 ( 전체 폭탄 설치됨)
		// time==3 -> 이전(0)에 설치한 폭탄 + 사방 모두 폭발 // 변화없음 -> 갱신해야함
		// time==4 -> 나머지 칸에 폭탄설치( 전체 폭탄 설치됨)
		// time==5 -> 이전(2)에 설치한 폭탄 모두 폭발 // 변화없음
		// time==6 -> 나머지 칸에 폭탄설치( 전체 폭탄 설치됨)
		// time==7 -> 이전(4)에 설치한 폭탄 모두 폭발 // 변화없음

		// time%2==0 -> 나머지 칸에 폭탄설치( 전체 폭탄 설치됨) (time>1)
		// time%2==1 -> 이전에 설치한 (time-3) 인 애들 폭발한다 (time >1)
		// time==0 -> 넘어간다
		// time==1 -> 넘어간다
		for (int time = 1; time <= N; time++) {
			//숫자인 애들을 -1 한다.
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] 	!= '.') map[i][j]--;
				}
			}
			
			if (time>1 && time % 2 == 0) {
				//'.'인 애들에 폭탄을 설치한다
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(map[i][j] == '.') map[i][j] = 3+'0';
					}
				}
			} else if(time>1 && time % 2 == 1) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(map[i][j] == '0')  {
							map[i][j] = '.';
							for (int d = 0; d < 4; d++) {
								int nr = i + dr[d];
								int nc = j + dc[d];
								
								if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
								map[nr][nc] = '.';
							}
						}
					}
				}

			}

			if (time == N) {
				printBomb(map);
			}
		}
	}

	private static void printBomb(char[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '.') System.out.print('O');
				else System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
