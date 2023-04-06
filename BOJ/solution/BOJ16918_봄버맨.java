//구현

package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
	static Queue<Pos> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

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
				if(map[i][j] == 'O') map[i][j] = 3 +'0';	//3초 카운팅을 하기 위해 3으로 바꿔서 넣어준다
			}
		}

		// time==0 -> 초기 폭탄 설치. 변화없음
		// time==1 -> 변화없음
		// time==2 -> 나머지칸에 폭탄 설치 ( 전체 폭탄 설치됨)
		// time==3 -> 이전(0)에 설치한 폭탄 + 사방 모두 폭발 // 변화없음
		// time==4 -> 나머지 칸에 폭탄설치( 전체 폭탄 설치됨)
		// time==5 -> 이전(2)에 설치한 폭탄 모두 폭발 // 변화없음
		// time==6 -> 나머지 칸에 폭탄설치( 전체 폭탄 설치됨)
		// time==7 -> 이전(4)에 설치한 폭탄 모두 폭발 // 변화없음

		// time%2==0 -> 나머지 칸에 폭탄설치( 전체 폭탄 설치됨) (time>1)
		// time%2==1 -> 이전에 설치한 (time-3) 인 애들 폭발한다 (time >1)
		// time==0 -> 넘어간다
		// time==1 -> 넘어간다

		//우리는 1,2,3,4,5,6초만 구해놓으면 3부터 그뒤로 항상 4를 주기로 반복 - 그려보면 보임
		int per = calPeriod(N);

		for (int time = 1; time <= per; time++) {
			//숫자인 애들을 -1 한다.
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] != '.') map[i][j]--;
				}
			}
			if(time==1) continue;
			//time이 짝수일때
			if (time % 2 == 0) {
				//'.'인 애들에 폭탄을 설치한다
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(map[i][j] == '.') map[i][j] = 3 +'0';
					}
				}
			} else {	//홀수일때
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						//놓은지 3초가 되어서 0으로 바뀐 애들을 폭탄을 터뜨려 평지로 바꿔줌
						if(map[i][j] == '0')  {
							map[i][j] = '.';
							//사방은 우선 다 찾아서 담고 한번에 터뜨린다
							q.add(new Pos(i,j));
						}
					}
				}
				bfs();
			}
		}
		//시간이 구하려던 시간이 됐을 때 맵을 출력한다
		printBomb(map);
	}

	private static int calPeriod(int N) {
		if(N==0 || N==1 || N==2) return N;
		if(N%4 == 3) return 3;
		return (N%4)+4;
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Pos p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				map[nr][nc] = '.';
			}
		}
	}

	private static void printBomb(char[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '.') sb.append('O');
				else sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
