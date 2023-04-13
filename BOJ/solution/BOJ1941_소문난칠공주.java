package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1941_소문난칠공주 {

	static class Pos {
		int r,c;
		char val;

		public Pos(int r, int c, char val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", val=" + val + "]";
		}
		
		
		
	}
	static int res;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<Pos> alist;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		v= new boolean[5][5];
		alist = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
				alist.add(new Pos(i,j,map[i][j]));
			}
		}
		//dfs가 안됨 - 다시 되돌아가는 구조이므로
		//25개라고 한정되어있으니까 25개 중에 7개를 뽑는다
		//하고 나서 bfs나 서로소집합을 이용해 하나로 이어져있는지 확인한다
		//그리고 S가 4개 이상인 지 확인
		comb(0,0,new Pos[7]);
		System.out.println(res);
	}

	

	private static void comb(int idx, int k, Pos[] sel) {
		
		if(k == sel.length) {
			//뽑은 리스트의 인덱스배열이 나온다
			//System.out.println(Arrays.toString(sel));
			if(checkArray(sel)) {
				res++;
			}
			return;
		}
		for (int i = idx; i < 25; i++) {
			sel[k] = alist.get(i);
			comb(i+1, k+1, sel);
		}
		
	}

	private static boolean checkArray(Pos[] choiceArr) {
		v = new boolean[5][5];
		//bfs사용해서 확인한다. 맞으면 res++
		int cnt=0;
		Queue<Pos> q = new LinkedList<>();
		q.add(choiceArr[0]);
		v[choiceArr[0].r][choiceArr[0].c] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				for(Pos pp : choiceArr) {
					if(nr == pp.r && nc == pp.c && !v[nr][nc]) {
						System.out.println(nr + " " + nc);
						v[nr][nc] = true;
						q.add(new Pos(nr, nc, map[nr][nc]));
						cnt++;
					}
				}
			}
		}
		
		if(cnt==7) {		
			if(checkSom(choiceArr)) {
				return true;
			}
			return false;
		}
		return false;
	}

	private static boolean checkSom(Pos[] p) {
		int cnt=0;
		for(Pos pp : p) {
			if(pp.val == 'S') cnt++;
		}
		//cnt가 4개 이상이면 true
		if(cnt>=4) return true;
		return false;
	}

}
