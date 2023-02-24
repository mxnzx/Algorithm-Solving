

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146_다리만들기 {
	
	static int N, tmp=0, Ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] v;
	static boolean[][] v2;
	static ArrayList<Point> list = new ArrayList<>();
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	private static class Point {
		int r,c,cnt=0;
		int islandNum;

		public Point(int r, int c, int cnt, int islandNum) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.islandNum = islandNum;
		}

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", islandNum=" + islandNum + "]";
		}

	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//가장 짧은 다리의 출력 - BFS? 
		//1을 찾고 더이상 못갈때까지 가다가 -> 거기부터 1씩 늘리면서 카운트 -> BFS 두개?
		//그 이후에 1을 만나면 종료
		int iNum = 2;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 1 && !v[r][c]) {
					//섬의 영역을 찾기 위한 bfs
					findIsland(r,c,iNum);
					iNum++;
					
				}
			}
		}
		//System.out.println(list);
		//가장 자리 애들이 각자 다리의 최소값을 리턴한다. BFS로 ㄱㄱ 다하면 나온 출력값끼리 비교 후 정답 리턴
		//System.out.println(list.size());
		//print(map);
		for (int i = 0; i < list.size(); i++) {
			v2 = new boolean[N][N];
			buildBridge(list.get(i));
		}
		System.out.println(Ans);
	}
	//다리를 짓는 메서드. BFS 탐색을 하므로 젤 먼저 나온 애가 최솟값이다
	private static void buildBridge(Point start) {
		//System.out.println(start);
		Queue<Point> q = new LinkedList<>();
		
		//큐에 넣기 전에 이미 들어간 좌표인지 확인해야되는데 일단 할게
		q.offer(start);	
		v2[start.r][start.c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];


				//영역 밖이거나 or 다음 갈 좌표가 내가 출발한 곳과 값이 같거나(=같은 섬이거나) or 이미 방문을 했다면 패스
				if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc] == start.islandNum || v2[nr][nc]) continue;

				
				//바다도 아닌데 다른 넘버의 섬을 만나면 끝!
				if(map[nr][nc] > 1 && map[nr][nc] != start.islandNum) {
					//현재 내 카운트와 최종값을 비교해서 작은 값을 뺀다
					Ans = Math.min(Ans, p.cnt);
					return;
				}
				
				//다음이 아직 바다면 킵고잉
				if(map[nr][nc] == 0) {
					//방문처리해주고
					v2[nr][nc] = true;
					//카운트 업해서 새 좌표를 넣어준다
					q.offer(new Point(nr, nc,p.cnt+1));
				}
				
			}
			
		}
	}
	//섬의 가장자리를 찾기 위한 BFS
	private static void findIsland(int r, int c, int islandNum) {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(r, c));
		v[r][c] = true;
		map[r][c] = islandNum;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || v[nr][nc]) continue;
				
				//아직 섬이 연결되어 있다면 ㄱ ㄱ
				if(map[nr][nc] == 1) {
					v[nr][nc] = true;
					map[nr][nc] = islandNum;
					q.offer(new Point(nr, nc));
				} else {	//더이상 갈 수 있는 곳이 없다면
					//체크할 Point리스트에 넣는다.
					//이미 들어갔는지 확인하고 넣어야하나? 일단 다 넣고 처리할때 걸러주자. 리스트에 넣을때 내 섬의 넘버 같이 넣어주기
					list.add(new Point(p.r, p.c, 0, islandNum));
					//System.out.println(list);
				}
				
			}
		}
		
	}
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}	
	}

}
