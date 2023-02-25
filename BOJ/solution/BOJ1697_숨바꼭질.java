/*
 * [BOJ]1697. 숨바꼭질
 * 최단거리 - BFS
 * 방문배열 꼭 생각해보고 짜기
 */

package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697_숨바꼭질 {

    static class Loc {
        int x,cnt;

        public Loc(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
    static int N,K;
    static boolean[] v = new boolean[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //수빈 위치
        K = sc.nextInt(); //동생 위치
        //가장 빠른시간 - BFS?
        //다해보자 -> DFS -> 1초씩 이동할때마다 걸을때와 순간이동할때 둘다 체크
        bfs(N);

    }

    //메모리 초과
    private static void bfs(int start) {

        Queue<Loc> q = new LinkedList<>();

        q.offer(new Loc(start,0));
        v[start]=true;
        while(!q.isEmpty()) {

            Loc p = q.poll();

            //현재 수빈의 위치가 동생의 위치와 같아지면 카운트 출력 후 리턴
            if(p.x == K) {
                System.out.println(p.cnt);
                return;
            }

            //왼쪽으로 걸었을 때
            if(p.x - 1 >= 0 && !v[p.x - 1]) {
                v[p.x - 1]=true;
                q.offer(new Loc(p.x-1,p.cnt+1));
            }

            //오른쪽으로 걸었을 때
            if(p.x + 1 <= 100000 && !v[p.x + 1]) {
                v[p.x + 1]=true;
                q.offer(new Loc(p.x+1,p.cnt+1));
            }
            //순간이동 했을 때
            if(p.x*2 >= 0 && p.x*2 <= 100000 && !v[p.x*2]) {
                v[p.x*2]=true;
                q.offer(new Loc(p.x*2,p.cnt+1));
            }

        }
    }

}
