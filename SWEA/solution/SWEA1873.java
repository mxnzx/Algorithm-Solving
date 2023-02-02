package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int startH, startW;
	static char startDir;

	//
	static void shooting(char currentDir, char[][] map, int currentH, int currentW, int h, int w) {
		int nr, nc;
		// 포탄 발사할 때 * 만나면 .
		// 포탄 발사할 때 # 만나면 중지
		// 포탄 발사할 때 나가면 다음 반복 실행
		switch (currentDir) {
		case '^':
			nr = currentH + dr[0];
			nc = currentW + dc[0];
			// 가장자리 조건 추가
			
			while (map[nr][nc] == '.') {
				if(nr < 0 || nr >= h || nc < 0 || nc >= w ) break;
				currentH = nr;
				currentW = nc;
				nr = currentH + dr[0];
				nc = currentW + dc[0];
			}
			if(map[nr][nc] == '*') {
				if(nr < 0 || nr >= h || nc < 0 || nc >= w ) break;
				map[nr][nc] = '.';
				currentH = nr;
				currentW = nc;
			}
			if(map[nr][nc] == '#' || map[nr][nc] == '-') {
				//아무일도 일어나지 않음
			}
			break;
		case '>':
			nr = currentH + dr[1];
			nc = currentW + dc[1];
			while (map[nr][nc] == '.') {
				if(nr < 0 || nr >= h || nc < 0 || nc >= w ) break;
				currentH = nr;
				currentW = nc;
				nr = currentH + dr[1];
				nc = currentW + dc[1];
			}
			if(map[nr][nc] == '*') {
				if(nr < 0 || nr >= h || nc < 0 || nc >= w ) break;
				map[nr][nc] = '.';
				currentH = nr;
				currentW = nc;
			}
			if(map[nr][nc] == '#' || map[nr][nc] == '-') {
				//아무일도 일어나지 않음
			}
			break;
		case 'v':
			nr = currentH + dr[2];
			nc = currentW + dc[2];
			while (map[nr][nc] == '.') {
				if(nr < 0 || nr >= h || nc < 0 || nc >= w ) break;
				currentH = nr;
				currentW = nc;
				nr = currentH + dr[2];
				nc = currentW + dc[2];
			}
			if(map[nr][nc] == '*') {
				if(nr < 0 || nr >= h || nc < 0 || nc >= w ) break;
				map[nr][nc] = '.';
				currentH = nr;
				currentW = nc;
			}
			if(map[nr][nc] == '#' || map[nr][nc] == '-') {
				//아무일도 일어나지 않음
			}
			break;
		case '<':
			nr = currentH + dr[3];
			nc = currentW + dc[3];
			while (map[nr][nc] == '.') {
				if(nr < 0 || nr >= h || nc < 0 || nc >= w ) break;
				currentH = nr;
				currentW = nc;
				nr = currentH + dr[3];
				nc = currentW + dc[3];
			}
			if(map[nr][nc] == '*') {
				if(nr < 0 || nr >= h || nc < 0 || nc >= w ) break;
				map[nr][nc] = '.';
				currentH = nr;
				currentW = nc;
			}
			if(map[nr][nc] == '#' || map[nr][nc] == '-') {
				//아무일도 일어나지 않음
			}
			break;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map = new char[h][w];

			// 맵 입력받기
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					// 전차 입력받으면 위치 저장해놓기
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						startH = i;
						startW = j;
						startDir = map[i][j];
					}
				}
			}
			// 현재 위치 초기값
			int currentH = startH;
			int currentW = startW;
			char currentDir = startDir;

			int n = Integer.parseInt(br.readLine());

			String str = br.readLine();
			for (int i = 0; i < n; i++) {
				// 문자 하나씩 입력받으면서 처리
				char c = str.charAt(i);
				// 가장자리 조건
				// 조건문 5개 만들기
				int nr, nc;
				switch (c) {
				// 좌표 이동 나오면 움직여라 //가장자리 조건 추가
				case 'U':
					nr = currentH + dr[0];
					nc = currentW + dc[0];
					// 내 위칸이 평지면 이동
					if (map[nr][nc] == '.' && nr >= 0) {
						map[currentH][currentW] = '.';
						currentH = nr;
						currentW = nc;
					}
					currentDir = '^';
					map[currentH][currentW] = currentDir;
					break;
				case 'L':
					
					nr = currentH + dr[3];
					nc = currentW + dc[3];
					// 내 왼쪽이 평지면 이동
					if (map[nr][nc] == '.' && nc >= 0) {
						map[currentH][currentW] = '.';
						currentH = nr;
						currentW = nc;
						
					}	
					currentDir = '<';
					map[currentH][currentW] = currentDir;
					break;
				case 'D':
					
					nr = currentH + dr[2];
					nc = currentW + dc[2];
					// 내 아래쪽이 평지면 이동
					if (map[nr][nc] == '.' && nr < h) {
						map[currentH][currentW] = '.';
						currentH = nr;
						currentW = nc;
					}
					currentDir = 'v';
					map[currentH][currentW] = currentDir;
					break;
				case 'R':
					nr = currentH + dr[1];
					nc = currentW + dc[1];
					// 내 오른쪽이 평지면 이동
					if (map[nr][nc] == '.' && nc < w) {
						map[currentH][currentW] = '.';
						currentH = nr;
						currentW = nc;
					}	
					currentDir = '>';
					map[currentH][currentW] = currentDir;
					break;
				case 'S':
					// currentDir가 어디냐 -> 4개로 나눠 switch case? - 메서드1로 빼자
					
					shooting(currentDir, map, currentH, currentW, h, w);
					break;
				}
			}

			// 맵 표시 - 갱신하기
			sb.append("#").append(t).append(" ");
			for(int i = 0; i < h; i++ ) {
				for(int j = 0; j < w; j++) {
					sb.append(map[i][j]).append(" ");  
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);

	}
}
