package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14467_소가길을건너간이유1 {
    static int[][] cow = new int[11][2];    //[][0]은 현재 길 위치를, [][1]은 처음 입력을 받았는지 체크배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int num, road;
        int Ans = 0;    //정답 출력 변수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            road = Integer.parseInt(st.nextToken());

            //처음 들어왔을 때
            if(cow[num][1] == 0) {
                cow[num][1] = 1;   // 체크배열에 체크(1)
                cow[num][0] = road;
                continue;
            }
            //이미 들어온 전적이 있을때
            if(cow[num][1] != 0 && cow[num][0] != road) {
                Ans++;
                cow[num][0] = road;
            }
        }
        System.out.println(Ans);
    }
}
