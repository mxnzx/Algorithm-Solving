/*
 * [SWEA]5656.벽돌깨기
 * 조합론(중복순열) + BFS
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656_벽돌깨기 {
    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int T, N, W, H, tmpAns, cntBrick,num;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());    //구슬 개수
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            num=0;  //초기 벽돌개수
            tmpAns = -1;
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    //0이 아닌 애들 카운팅
                    if(map[i][j] != 0) num++;
                }
            }
            //구슬을 놓을 열 3개를 뽑는다. 중복 가능. 순서 있음 => 중복순열
            perm(new int[N], 0);

            //최종값 출력
            if(tmpAns == -1) tmpAns=0;
            sb.append("#").append(tc).append(" ").append(num-tmpAns).append("\n");
        }
        System.out.println(sb);
    }

    private static void perm(int[] sel, int k) {
        if (k == N) {
            //System.out.println(Arrays.toString(sel));
            searchLoc(sel);
            return;
        }
        for (int i = 0; i < W; i++) {
            sel[k] = i;
            perm(sel, k + 1);
        }
    }
    //깰때마다 수를 센다 -> 한 세트 완료했으면 비교 후 갱신
    private static void searchLoc(int[] sel) {
        //복사한 맵 가져오기
        int[][] tmpMap = copyMap();
        cntBrick = 0;

        //구슬 수만큼 반복
        for (int cnt = 0; cnt < N; cnt++) {
            int r = -1;
            int c = sel[cnt];
            //첫번째 구슬 떨어진 위치의 맵의 값을 찾는다
            for (int i = 0; i < H; i++) {
                if (tmpMap[i][c] != 0) {
                    r = i;
                    break;
                }
            }
            //r의 값이 -1이라면(=해당 열에 값이 없다면) 리턴
            if (r == -1) return;
            //벽돌을 깨러 가자
            breakBrick(r,c,tmpMap);
            //깨진 벽돌수가 처음 벽돌수와 같으면 다 깬것이므로 반복문 탈출한다.
            if(cntBrick == num) break;
        }
        //N개의 구슬이 다 떨어졌으면 값을 비교한다. 나중에 맨 처음 값에서 tmpAns값을 뺀 값이 최솟값이 나와야 하므로 이 tmpAns값은 최대가 되어야 함.
        tmpAns = Math.max(tmpAns, cntBrick);

    }
    //벽돌을 깨면서 깨진 벽돌을 0으로 만드는 메서드
    private static void breakBrick(int r, int c,int[][] tmpMap) {
        int val;
        //사방으로 돌면서 0으로 만든다
        Queue<Point> q = new LinkedList<>();
        //큐에 처음 구슬을 떨어뜨린 좌표를 넣어준다
        q.add(new Point(r,c));

        //큐가 빌 때까지 돌린다.
        while (!q.isEmpty()) {
            Point p = q.poll();
            val = tmpMap[p.r][p.c]; //이 값만큼 반복해서 사방의 벽돌을 얼마나깰지 정한다.
            //벽돌을 깰때마다(=0이 아닌 값들을 0으로 바꿀때마다 깬 벽돌수를 카운팅
            if(tmpMap[p.r][p.c] != 0) {
                tmpMap[p.r][p.c] = 0;
                cntBrick++;   //0으로 바꾼 애들이 나올 때마다 더해준다
            }

            //다 없애면 종료한다.(깬 벽돌이 처음 벽돌 수와 같아지면 바로 리턴한다)
            if(cntBrick == num) return;

            //사방을 벽돌이 가진 값만큼 뻗어나가며 돌면서 연쇄적으로 벽돌을 깨기 위해 해당 벽돌을 큐에 넣어준다
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < val; i++) {
                    int nr = p.r + dr[d]*i;
                    int nc = p.c + dc[d]*i;
                    if(nr<0 || nr>=H || nc<0 || nc>=W || tmpMap[nr][nc] == 0) continue;
                    q.add(new Point(nr,nc));
                }
            }
        }
        //나와서 비어있는 벽돌자리 내려주기(=0으로 비어진 자리 맞춰준다)
        //print(tmpMap);
        alignMap(tmpMap);
        //print(tmpMap);
    }

    //맵의 값들(=벽돌)을 재배치하는 메서드 => 스택으로 구현할 수 있다는데 최적화 시키기
    private static void alignMap(int[][] tmpMap) {
        //밑에서부터 돌다가 0이 아닌 것들을 tmpArr배열에 담아놓고 걔네를 다시 원래 열에 넣어준다
        for (int i = 0; i < W; i++) {
            int[] tmpArr = new int[H];
            int cnt=0;
            for (int j = H-1; j >= 0; j--) {
                if(tmpMap[j][i] != 0) {
                    tmpArr[cnt++] = tmpMap[j][i];
                }
            }
            int cnt2=0;
            for (int j = H-1; j >= 0; j--) {
                tmpMap[j][i] = tmpArr[cnt2++];
            }
        }
    }
    //원본맵을 카피하는 메서드
    private static int[][] copyMap() {
        int[][] tmpMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
        return tmpMap;
    }
}
