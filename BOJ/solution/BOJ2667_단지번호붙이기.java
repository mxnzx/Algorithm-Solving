/*
 * [BOJ]2667. 단지번호붙이기
 * 2차원배열(지도) 따라 다니면서 해결하는 문제 - 델타 배열과 BFS를 생각하자
 * 옆으로 돌면서 하나씩 봐야하는 문제. 
 * 좌표 2개를 계속 써야하므로 2차원 배열을 만들거나 클래스를 생성해주면 되는데, 웬만하면 클래스 가지고서 하자. 
 * 막힌 부분 - ArrayList 정렬하는 방법 암기하기 - Collections.sort()
 * 막힌 부분2 - 클래스 안에 클래스 생성 가능 - Nested Class 대해서 공부하기. 
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BOJ2667_단지번호붙이기 {
	
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int cnt = 0;  //단지의 개수
		List<Integer> aList = new ArrayList<Integer>();
		//1을 찾아서 돌린다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					cnt++;
					aList.add(bfs(i,j,0));
				}
			}
		}
		sb.append(cnt + "\n");
		Collections.sort(aList);
		for (Integer i : aList) {
			sb.append(i + "\n");
		}
		
		System.out.println(sb);
		br.close();
		

	}
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	
	private static int bfs(int r, int c, int houseNum) {
		Queue<Point> queue = new LinkedList<>();

		boolean[][] v = new boolean[N][N];
		v[r][c] = true;
		
		queue.offer(new Point(r, c));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			map[p.r][p.c] = 0;	//1을 찾았으면 0으로 바꾼 후 연결된 노드 찾으러 감
			houseNum++;         //0으로 바꿔줄때마다 집 개수 업
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
				
			}
		}
		
	return houseNum;	
	}
	
	

}
