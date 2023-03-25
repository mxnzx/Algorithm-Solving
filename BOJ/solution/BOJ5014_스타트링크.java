/*
 * [BOJ]5014. 스타트링크 - bfs
 * bfs는 cnt를 자신이 가지고 있어야 한다. + 방문배열 처리 허둥대지 말자
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014_스타트링크 {
    static class Loc {
        int s,cnt;

        public Loc(int s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }
    static int F,S,G,U,D,res;
    static boolean[] v;
    static boolean done;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());   //가장 높은 층. (=건물층수)
        S = Integer.parseInt(st.nextToken());   //현재 위치
        G = Integer.parseInt(st.nextToken());   //목적지
        U = Integer.parseInt(st.nextToken());   //위로 U만큼
        D = Integer.parseInt(st.nextToken());   //아래로 D만큼

        v = new boolean[F+1];
        bfs();

        //결과
        if(done) System.out.println(res);
        else System.out.println("use the stairs");
    }
    private static void bfs() {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(S,0));
        v[S] = true;

        while(!q.isEmpty()) {
            Loc p = q.poll();

            //목적지에 도착하면 내 카운트 값 보내고 리턴. bfs이므로 최솟값이 나온다
            if(p.s == G) {
                res = p.cnt;
                done = true;
                return;
            }

            int next;
            //올라가는 버튼을 누른 경우
            next = p.s + U;
            if(next<=F && !v[next]) {
                q.add(new Loc(next, p.cnt+1));
                v[next] = true;
            }
            //내려가는 버튼을 누른 경우
            next = p.s - D;
            if(next>=1 && !v[next]) {
                q.add(new Loc(next, p.cnt+1));
                v[next] = true;
            }
        }
    }

}
