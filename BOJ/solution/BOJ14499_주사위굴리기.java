//[BOJ]14499. 주사위굴리기 - 구현
// 하나씩 조건 잘 따져가며 주기

package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499_주사위굴리기 {

	static int N,M,x,y,K;
	static int[][] map;
	static int[] dice;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());	//세로(행)
		y = Integer.parseInt(st.nextToken());	//가로(열)
		K = Integer.parseInt(st.nextToken());
		
		dice = new int[7];	//인덱스 1~6. 배열값이 주사위에 표시되어있는 수. 주사위 인덱스 위치는 고정.(1이 항상 윗면)
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			//입력받으면서 구하자
			int dir = Integer.parseInt(st.nextToken());
			move(dir);
		}
		System.out.println(sb);
	}
	private static void move(int dir) {
		// 이동 방향이 동 서 남 북 -> 따라 케이스 분류
		// 지도가 0이면 주사위 바닥면 복사 // 주사위가 0이면 지도면 복사 + 칸(map) 값은 0이 된다
		int nx = x;
		int ny = y;
		int tmp;
		switch (dir) {
		case 1:			//동
			ny+=1;
			if(ny>=M) {
				ny-=1;
				return;
			}
			tmp = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = tmp;
			break;
		case 2:			//서
			ny-=1;
			if(ny<0) {		//가장자리 조건 체크
				ny+=1;
				return;
			}
			tmp = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = dice[1];
			dice[1] = tmp;
			break;
			
		case 3:			//북
			nx-=1;
			if(nx<0) {
				nx+=1;
				return;
			}
			tmp = dice[6];
			dice[6] = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = tmp;
			break;
		case 4:			//남
			nx+=1;
			if(nx>=N) {
				nx-=1;
				return;
			}
			tmp = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = tmp;
			break;
		}
		//지도와 주사위 값 설정하기
		if(map[nx][ny] == 0) map[nx][ny] = dice[6];
		else { 
			dice[6] = map[nx][ny];
			map[nx][ny] = 0;
		}
		sb.append(dice[1]).append("\n");
		//x,y값 옮겨져 있는 좌표로 재설정
		x = nx;
		y = ny;
	}
}
