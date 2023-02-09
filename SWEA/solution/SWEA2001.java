/*
 * SWEA2001. 파리 퇴치
 * M * M 배열안의 가장 큰 값을 찾는 문제 -> 중복X, 순서X 다돌아야 함
 * 완전탐색
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
	static int T, N, M;
	static int[][] map;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        
        T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            map = new int[N][N];
            
            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            // 구간 합 구하기
            int[][] prefixMap = new int[M][M];
            for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					prefixMap[i][j] += map[i][j];
				}
			}
            
            for
            int sum=0;
            
            for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					sum += map[i][j];
				}
			}
            max = Math.max(max, sum);
            
            
            
		}
        

	}

}
