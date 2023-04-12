package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<Pos> som, yeon;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		v= new boolean[5][5];
		som = new ArrayList<>();
		yeon = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') som.add(new Pos(i,j));
				if(map[i][j] == 'Y') yeon.add(new Pos(i,j));
			}
		}
		//dfs가 안됨 - 다시 되돌아가는 구조이므로
		//25개라고 한정되어있으니까 25개 중에 7개를 뽑는다 -> 일단 S를 먼저 뽑고 -> 나머지 Y를 고른다 (4,3) (5,2) (6,1) (7,0)
		//S가 몇 개 있는지 체크하고 4~N개 까지 파워셋?
		//하고 나서 bfs나 서로소집합을 이용해 하나로 이어져있는지 확인한다
		//선택하면 그걸 O로 바꾸자
		int per = som.size()-4;	//5-4=1
		for (int i = 0; i <= (per = som.size()>7?3:per); i++) {
			//다솜이를 4+i개 뽑는다
			somComb(0,0,new Pos[4+i]);
		}
		
		System.out.println(res);
		

	}

	private static void somComb(int idx, int k, Pos[] sel) {
		if(k==sel.length) {
			//임도연배열과 이다솜배열을 합쳐서 뭉쳐있는지 확인한다
			Pos[] addComb = new Pos[7];
			System.arraycopy(sel,0,addComb,0,sel.length);
			Pos[] p = yeonComb(0,0,new Pos[7-sel.length]);
			System.arraycopy(p,0,addComb,sel.length, p.length);
			//p가 다 붙어있는지 확인한다
			checkArray(p);
			return;
		}
		for (int i = idx; i < som.size(); i++) {
			sel[k] = som.get(i);
			somComb(i+1, k+1, sel);
		}
	}

	private static void checkArray(Pos[] p) {
		//bfs사용해서 확인한다. 맞으면 res++

		Queue<Pos> q = new LinkedList<>();
		]
		q.add(new Pos());

	}

	private static Pos[] yeonComb(int idx, int k, Pos[] sel) {
		if(k==sel.length) {
			return sel;
		}
		for (int i = idx; i < yeon.size(); i++) {
			sel[k] = yeon.get(i);
			yeonComb(i+1, k+1, sel);
		}
		return sel;
	}


}
