/*
 * [BOJ]4963. 섬의개수
 * 막힌 부분 : 대각선도 포함이므로 팔방탐색
 * 막힌 부분2: main에서 1(섬)인 조건 찾을 때 방문 했는지도 같이 조건에 걸어줘야 한다. 그냥 미리 걸기(팔방일 경우 필수로 걸어야 함(?))
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import sun.awt.util.IdentityLinkedList;

public class BOJ4963_섬의개수 {

    static int w,h;
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str;

        //EOF. 0 0 아닐때까지
        while(!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);
            w = Integer.parseInt(st.nextToken());  //3
            h = Integer.parseInt(st.nextToken());  //2

            map = new int[h][w];
            v = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0; //섬 개수 카운팅
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !v[i][j]) {
                        cnt++;
                        bfs(i,j);
                    }
                }

            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			
			Point p = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr>=0 && nr<h && nc>=0 && nc<w && map[nr][nc] == 1 && !v[nr][nc]) {
					v[nr][nc] = true;
					q.offer(new Point(nr, nc));
				}
			}
		}
    	
    	
	}
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
    static int[] dc = {-1,0,1,1,1,0,-1,-1};

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    

   
}
