/*
 * [BOJ]15686. 치킨배달
 * 1. 조합 + BFS 으로 풀었다가(main2) 시간&메모리 둘다 남들의 10배씩 걸려서 다른 방법을 찾아보았다
 * 2. 값을 받아올 때 치킨집과 집의 좌표를 미리 받아 리스트를 만들어놓고, 조합으로 M개의 치킨집을 만들고 백트래킹을 통한 완전탐색을 통해 모든 경우를 구해보는게 더 빠름
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15686_치킨배달 {

    static int N, M, cur, Ans;  //cur: 조합나누어서 풀어야할 때 나오는 임의의 도시의 치킨 거리들.  Ans: 최종
    static int[][] map;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static ArrayList<Point> chickenList = new ArrayList<>();    //치킨집 위치를 저장하는 리스트
    static ArrayList<Point> houseList = new ArrayList<>();      //집의 위치를 저장하는 리스트
    static boolean[] chickenV;

    //백트래킹 + 조합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());   //가장 수익을 많이 낼 치킨집 개수 최대 M

        map = new int[N][N];
        Ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //받으면서 1,2값이면   치킨집, 집을 카운트
                if (map[i][j] == 1) houseList.add(new Point(i, j));
                if (map[i][j] == 2) chickenList.add(new Point(i, j));
            }
        }
        chickenV = new boolean[chickenList.size()];
        backtracking(0,0);  //m개의 치킨집을 뽑는다.
        System.out.println(Ans);

    }

    //idx: 원본 리스트 인덱스.  k: 선택한 인덱스
    //완전 탐색 브루트포스
    private static void backtracking(int idx, int k) {
        //M개의 치킨집을 골랐으면,
        if(k==M) {
            int total = 0;   //도시의 치킨거리
            //집의 좌표값을 알고 있으므로 그 집들을 하나씩 고른다
            for (int i = 0; i < houseList.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size(); j++) {
                    //치킨집 좌표 리스트를 돌다가 골라놓은 M개의 중 하나의 치킨집이라면 거리를 구해준다
                    if(chickenV[j]) {
                        int dist = Math.abs(houseList.get(i).r - chickenList.get(j).r)
                                 + Math.abs(houseList.get(i).c - chickenList.get(j).c);
                        //치킨집과의 거리중에 가장 짧은 거리를 도시의 치킨 거리를 구할 때 더해줄 것이다.
                        sum = Math.min(sum,dist);
                    }
                }
                total += sum;

            }
            //구해놓은 도시의 치킨 거리중에 가장 작은 값을 출력한다.
            Ans = Math.min(total, Ans);
            return;
        }

        //치킨집 m개를 뽑는다
        for (int i = idx; i < chickenList.size(); i++) {
            if(!chickenV[i]) {
                chickenV[i] = true;
                backtracking(i+1, k+1);
                chickenV[i] = false;
            }
        }
    }

    //=========================== 원래 풀었던 조합 + BFS 방식 =====================================
    static boolean[][] v;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());   //가장 수익을 많이 낼 치킨집 개수 최대 M

        map = new int[N][N];
        Ans = Integer.MAX_VALUE;

        int cnt2 = 0;       //치킨집(2) 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //받으면서 2값이면 카운트
                if (map[i][j] == 2) cnt2++;
            }
        }

        //경우의 수1)
        //M보다 2의 개수가 더 많으면 전처리 작업으로 2의 개수로 M개로 맞춰야 함.
        //M개의 치킨집을 조합으로 잡고 각 집과의 거리를 비교해 거리가 제일 작은 M개의 치킨집을 뽑자. -> BFS?
        Point[] chicken = new Point[cnt2];  //치킨집 좌표 배열
        int n = 0;
        if (cnt2 > M) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 2) chicken[n++] = new Point(i, j);
                }
            }
            //이것들로 M개의 조합을 만들어야 한다 (cnt2 C M)
            comb(chicken, new Point[M], 0, 0);

        } else {
            //경우의 수2)
            //치킨집을 폐업시킬 필요가 없을때는 바로 도시의 치킨 거리의 최솟값을 구한다. 이때 치킨집값도 3으로 바꿔주고 시작
            cur=0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 2) map[r][c] = 3;
                }
            }
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 1) {
                        //치킨집을 찾아 거리를 더한다
                        cur += homeToChickenDist(r,c);
                        //System.out.println("return: "+cityDist(r, c));     //0,3
                    }
                }
            }
            Ans = cur;

        }
        //최종 값 출력
        System.out.println(Ans);
    }

    //조합 생성 메소드
    private static void comb(Point[] og, Point[] sel, int idx, int k) {

        if (k == sel.length) {
            // M개의 조합이 생성됐다면, 선택된 애들을 따로 표시하기 위해 3으로 값을 변경한다.
            for (Point point : sel) {
                map[point.r][point.c] = 3;
            }
            //그리고 도시의 치킨 거리를 구한다.
            //1. 1을 찾고 가장가까운 선택된 치킨집(3)를 찾아 거리를 구한다
            cur=0;  //각 집에서 치킨집과의 거리의 합 ( 임의의 도시의 치킨 거리)
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 1) {
                        //치킨집을 찾아 거리를 더한다
                        cur += homeToChickenDist(r,c);
                        //System.out.println("return: "+cityDist(r, c));     //0,3
                    }
                }
            }

            //현재 출력 값이랑 비교해서 더 작은 것을 뽑는다
            Ans = Math.min(cur, Ans);

            //바꾼 값 원상복구
            for (Point point : sel) {
                map[point.r][point.c] = 2;
            }
            return;
        }
        if (idx == og.length) return;

        //넣고
        sel[k] = og[idx];
        comb(og, sel, idx + 1, k + 1);
        //안넣고
        comb(og, sel, idx + 1, k);

    }

    // 한 집에서의 치킨거리를 구하는 메소드
    private static int homeToChickenDist(int r, int c) {
        v = new boolean[N][N];

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c));
        v[r][c] = true;

        int level = 0;
        //3을 찾을때까지
        while (!q.isEmpty()) {
            int size = q.size();
            for (int cnt = 0; cnt < size; cnt++) {
                Point p = q.poll();

                //치킨집을 만나면 거리를 계산한다. 이 거리는 큐의 트리 레벨과 같음
                if (map[p.r][p.c] == 3) return level;

                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
                        q.offer(new Point(nr, nc));
                        v[nr][nc] = true;
                    }
                }

            }
            level++;
        }
    return 0;
    }

}
