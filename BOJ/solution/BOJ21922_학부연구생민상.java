/*
 *[BOJ]21922. 학부연구생민상
 * 놓친 부분: 조건 실수들.좀 더 코드 짤 때 집중하면서 나아가기.
 * 테케 다 맞는 구현 디버깅이 너무 어렵다 ..
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ21922_학부연구생민상 {
    static int N,M;
    static int[][] map;
    static boolean[][] v;
    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<Point> air = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    //에어컨 좌표 저장 리스트에 추가 + 방문 추가
                    air.add(new Point(i,j));
                    v[i][j] = true;
                }
            }
        }
        //에어컨을 하나씩 찾아 돈다
        for(Point p : air) {
            checkAir(p);
        }
        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(v[i][j]) cnt++;
            }
        }
        System.out.println(cnt);

    }
    //p: 현재 에어컨 위치 Point
    private static void checkAir(Point p) {
        for (int d = 0; d < 4; d++) {
            int nr = p.r + dr[d];
            int nc = p.c + dc[d];

            if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
            goAir(p, new Point(nr,nc), d);
        }
    }
    //init:처음 위치, p: 현재위치 d : 현재방향(상0 하1 좌2 우3)
    //한 방향에서의 dfs
    //조건: 내 처음자리로 돌아오면 멈춘다 + 더이상 갈수 없으면 멈춘다
    //갈수있는길 지날때마다 v 체크
    private static void goAir(Point init, Point p, int d) {
        v[p.r][p.c] = true;
        int nr,nc;
        switch (map[p.r][p.c]) {
            //0이면 현재 방향 가지고 간다
            case 0:
            //내 방향(d)이  좌우(2,3)인 경우에만 종료. 아니면 똑같이 ㄱㄱ
                break;
            case 1:
                if(d==2 || d==3) return;
                break;
            //내 방향(d)이  상하(0,1)인 경우에만 종료. 아니면 똑같이 ㄱㄱ
            case 2:
                if(d==0 || d==1) return;
                break;

            //d를 바꾼다. 현재 상->우 / 하->좌 /좌->하 / 우->상
            case 3:
                if (d==0) d=3;
                else if (d==1) d=2;
                else if (d==2) d=1;
                else if (d==3) d=0;
                break;
            //d 바꾼다.   상->좌 / 하->우 / 좌->상 / 우->하
            case 4:
                if (d==0) d=2;
                else if (d==1) d=3;
                else if (d==2) d=0;
                else if (d==3) d=1;
                break;
            case 9:
                return;
        }
        nr = p.r + dr[d];
        nc = p.c + dc[d];
        //내 처음자리(에어컨이 있던=시작한자리)로 돌아오면 멈춘다 + 더이상 갈수 없으면 멈춘다
        if(nr<0 || nr>=N || nc<0 || nc>=M || (nr==init.r && nc== init.c)) return;
        goAir(init,new Point(nr,nc),d);

    }

//    private static void print(int[][] map){
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//    }
//    private static void print(boolean[][] map){
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
