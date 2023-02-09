/*
 * BOJ1160. 구간 합 구하기 5
 * 구간을 무조건 1,1 부터
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ11660 {
    static int N, M;
    static int[][] map, prefixSumMap;
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
        
        prefixSumMap = new int[N+1][N+1];
        //1. map의 부분 합들을 구해 새로운 맵에 넣는다.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
            	//내가 구할 곳은 구간 합     =  내 좌표 값     +  내 위쪽에 있는 좌표 구간합의 값  + 내 왼쪽에 있는 좌표 구간합의 값 - 중복된 구간을 다시 제외
            	prefixSumMap[i][j] = map[i][j] + prefixSumMap[i-1][j] + prefixSumMap[i][j-1] - prefixSumMap[i-1][j-1];
            }
        }
        
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//            	//내가 구할 곳은 구간 합     =  내 좌표 값     +  내 위쪽에 있는 좌표 구간합의 값  + 내 왼쪽에 있는 좌표 구간합의 값 - 중복된 구간을 다시 제외
//            	System.out.print(prefixSumMap[i][j] + " ");
//            }
//            System.out.println();
//        }

        Coord start;
        Coord end;
        //테스트 케이스 마다 구해준다
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            end = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int sum = 0;

            

            sb.append(sum).append("\n");
        }

    }
}


