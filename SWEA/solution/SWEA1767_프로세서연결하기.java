package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 많은 전원을 연결하는 게 우선 - 전부다 찾아가면서 연결한다
 */
public class SWEA1767_프로세서연결하기 {
	static class Point {
		int r,c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	static int T,N;
	static int[][] map, dist;
	static boolean[][] v;
	static ArrayList<Point> core = new ArrayList<>();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T=Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = br.readLine().charAt(0) - '0';
			map = new int[N][N];
			v = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						core.add(new Point(i,j));
					}
				}
			}
			//탐색하는 순서를 바꿔가면서 다 구해봐야될것같음
			//순열(0~core.size-1까지 전부다뽑는 순열을 구한다. nPn
			int n = core.size();
			perm(new boolean[n], new int[n],n,0);

		}

	}
	//sel: 뽑을 배열, n: 뽑아야되는 개수, idx: 다음 값, k:뽑은 개수
	//순열 코드
	private static void perm(boolean[] v, int[] sel,int n,int k) {
		if(k == n) {
			dijkstra(sel);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(!v[i]) {
				sel[k] = i;
				v[i] = true;
				perm(v,sel,n,k+1);
				v[i] = false;
			}
		}
	}

	private static void dijkstra(int[] sel) {
		v = new boolean[N][N];	//할때마다 방문배열 새로
		PriorityQueue<Point> q = new PriorityQueue<>();
		for (int i = 0; i < core.size(); i++) {
			q.add(core.get(i));


		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);

			}
			System.out.println();
		}
	}

}
