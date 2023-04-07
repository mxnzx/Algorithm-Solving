package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1941_소문난칠공주 {

	static class Pos { 
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int res;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<Pos> som;
	public static void main(String[] args) throws IOException {
		//S를 먼저 찾아서 7개를 모은다
		//-> 중간에 Y가 4개 이상되면 리턴,
		//그럼 도착했을 때 무조건 되는애들이니까 그냥 카운팅하자
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		som = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') som.add(new Pos(i,j));
			}
		}
		
		
		

	}

}
