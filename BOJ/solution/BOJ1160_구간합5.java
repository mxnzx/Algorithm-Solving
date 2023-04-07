package solution;

/*
 * BOJ1160. 구간 합 구하기 5
 * 구간을 무조건 1,1 부터
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1160_구간합5 {
	
	static class Pos {
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
    static int N, M;
    static int[][] map, prefixSum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        // 0. map의 값 입력받기. 입력은 1,1부터 주었고, 그 바깥쪽(0,_) (_,0) 은 0으로 값이 초기화 되어있을 것이다.
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prefixSum = new int[N+1][N+1];

        //dp테이블 - 바텀 업
        for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				prefixSum[i][j] = map[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
			}
		}
        Pos start, end;
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	
        	int ans = prefixSum[end.r][end.c] - prefixSum[end.r][start.c-1] - prefixSum[start.r-1][end.c] + prefixSum[start.r-1][start.c-1];
        	sb.append(ans).append("\n");
		}
        System.out.println(sb);

    }
    
}


