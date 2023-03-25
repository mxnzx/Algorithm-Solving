/*
 * [BOJ]2638. 치즈 - bfs
 * 실수 : 실수가 반복되면 실력인데 ,, 지금 계속 방문배열 두는 위치 때문에 몇문제가 틀린거냐
 *      큐에 넣을 때 중복되게 들어가는지 꼭 확인. 웬만하면 들어갈 때 넣는게 맞다 bfs는 큐에 넣을때 로직을 생각해보고 처리하자
 *      이번 문제는 0을 만나면 큐에 넣는거였으니 넣을 때 방문처리를 했어야 그 칸이 중복으로 큐에 들어가지 않겠지 ???
 * 몰랐던 부분: 치즈를 타야한다고만 생각했다. 발상의 전환 + 이런 유형 잘 기억하기
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638_치즈 {
        static class Point {
            int r, c;

            public Point(int r, int c) {
                super();
                this.r = r;
                this.c = c;
            }

            @Override
            public String toString() {
                return "Point [r=" + r + ", c=" + c + "]";
            }
        }

        static int[][] map;
        static boolean[][] v;
        static int N, M, cheeseSize, cnt;
        static int[] dr = { -1, 1, 0, 0 };
        static int[] dc = { 0, 0, -1, 1 };
        static ArrayList<Point> cheese = new ArrayList<>();

        public static void main(String[] args) throws IOException {
            // TODO Auto-generated method stub
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            v = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1)
                        cheese.add(new Point(i, j));
                }
            }
            //1. 가장자리는 무조건 0이므로 (0,0)타면서 가장자리에 -1로 씌워줌
            //2. -1이 사방에 있으면 카운트 업
            //3. 2변 이상이 -1인 애들은 값이 3이 되었고, 이들을 전부 0으로 처리
            //  3.5. 0으로 바뀐 애들을 처음 치즈값에서 뺌
            //4. 반복 - 치즈 개수가 0이되면 종료. 반복할때 cnt 카운팅

            cheeseSize = cheese.size();  //치즈 개수

            while (cheeseSize > 0) {
                cnt++;
                bfs();
                //-1인 애들 다시 0으로 바꾼다. 남아있는치즈조 1로 바꾼다
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if(map[i][j] == -1) map[i][j] = 0;
                        else if (map[i][j] > 0) {
                            map[i][j] =1;
                        }
                    }
                }

            }
            System.out.println(cnt);

        }
        //가장자리 -1로 바꾸고 실행하는 메서드
        private static void bfs() {
            v = new boolean[N][M];
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(0,0));
            v[0][0] = true;

            while (!q.isEmpty()) {
                Point p = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];

                    if(nr<0 || nr>=N || nc<0 || nc>=M || v[nr][nc]) continue;

                    if(map[nr][nc] == 1) map[p.r][p.c] = -1;
                    else if(map[nr][nc] == 0) {
                        q.add(new Point(nr,nc));
                        v[nr][nc] = true;
                    }
                }

            }
//            for(Point chz : cheese) {
//                checkAir(chz);
//            }
            //치즈 리스트를 돌면서 사방에 -1이 있으면 자신을 올린다
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1) checkAir(new Point(i,j));
                }
            }
            // 3인 애들 0으로 바꾼다
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 3) {
                        map[i][j] = 0;
                        cheeseSize--;
                    }
                }
            }
        }

        private static void checkAir(Point p) {
            for (int d = 0; d < 4; d++) {
                if(map[p.r][p.c] == 3) return;

                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(map[nr][nc] == -1) map[p.r][p.c]++;

            }
        }
        private static void print(int[][] map) {
            for (int i = 0; i < N; i++) {

                for (int j = 0; j < M; j++) {
                    System.out.print(map[i][j]);

                }
                System.out.println();
            }
            System.out.println();

        }

    }

