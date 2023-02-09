/*
 * SWEA2001. 파리 퇴치
 * M * M 배열안의 가장 큰 값을 찾는 문제 -> 중복X, 순서X 다돌아야 함
 * 완전탐색
 */

package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
	static int T, N, M;
	static int[][] map;
	static int max, sum;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        
        T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {

        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            map = new int[N][N];
			max = 0;
            
            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sum = 0;
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					for (int k = i; k < M+i; k++) {
						for (int l = j; l < M+j; l++) {
							sum += map[k][l];
						}
					}
					max = Math.max(max, sum);
					sum = 0;
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			//위 코드를 재귀로 ?
//			subSum(0,0);
		}

		System.out.println(sb);
		br.close();
	}
//	private static void subSum(int r, int c) {
//
//
//		sum += map[r][c];
//		subSum(r+1,c);
//		subSum(r,c+1);
//		subSum();
//	}

}
