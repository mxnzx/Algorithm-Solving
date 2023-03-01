/*
 * [BOJ]17471.게리맨더링 - 조합론, MST(프림)
 * N개가 들어오면 1~N-1개로 구간을 나누고
 * 각자의 그룹이 MST를 이루는지 확인
 * 이루면 각 인구수의 합을 구하고 두 지역의 차를 기록하고 이를 갱신
 * MST를 어떠한 조합도 이루지 못했으면 flag가 계속 false로 있다가 마지막에 -1출력
 *
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17471_게리맨더링 {

    static int N, Ans=Integer.MAX_VALUE;

    static boolean[] v, divTeam;
    static int[] area;  //지역(정점)별 인구수 - idx는 지역으로 쓸 예정
    static ArrayList<Integer>[] adjList;
    static boolean flag = false;   //게리맨더링 만족했는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        area = new int[N + 1];
        divTeam = new boolean[N+1]; //지역 나눌 때 사용할 배열
        adjList = new ArrayList[N + 1];   //인접리스트
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        //인구 수 입력받기(인덱스1부터)
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            area[i] = Integer.parseInt(st.nextToken());
        }
        //인접리스트 생성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                adjList[i].add(a);
                adjList[a].add(i);
            }
        }
        //내가 1~N/2만큼을 뽑는다
        for (int i = 1; i <= N/2; i++) {
            comb(i,1,0);
        }
        if(flag) System.out.println(Ans);
        else System.out.println(-1);

    }
    //n: 뽑을 개수(1~3), idx: 정점 인덱스(지역) k:현재까지 뽑은 개수
    private static void comb(int n, int idx, int k) {

        if(k == n) {
            //System.out.println(Arrays.toString(divTeam));
            //뽑을 개수만큼 뽑았으면 게리맨더링을 진행한다
            gerrymandering();
            return;
        }

        for (int i = idx; i <= N ; i++) {
            divTeam[i] = true;
            comb(n,i+1,k+1);
            divTeam[i] = false;
        }
    }

    private static void gerrymandering() {

        //선택된 지역인덱스를 A그룹이라고 하자. 선택되지 않은 지역 인덱스를 B그룹이라고 하자.
        ArrayList<Integer> teamA = new ArrayList<>();
        ArrayList<Integer> teamB = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(divTeam[i]) teamA.add(i);
            else teamB.add(i);
        }

        //각 그룹이 ST를 이루는지 확인한다.
        int sumA=0, sumB=0;
        //두 지역 다 신장트리를 이루면,
        if(checkMST(teamA,teamA.size()) && checkMST(teamB,teamB.size())) {
            //인구 수를 다 더한다.
            for(int i : teamA) sumA += area[i];
            for(int i : teamB) sumB += area[i];
            flag = true;    //한번의 게리맨더링이 실행되면 flag를 true로 바꿔준다
            //최솟값 갱신
            Ans = Math.min(Ans, Math.abs(sumA-sumB));
        }


    }

    //프림 알고리즘을 통해 신장트리를 이루는지 체크한다(=같은 선거구가 연결되어 있는지 확인한다)
    private static boolean checkMST(ArrayList<Integer> alist, int size) {
        v = new boolean[N + 1];   //방문배열
        int cnt = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        //임의로 첫번째 원소 고른다
        q.add(alist.get(0));
        //방문처리
        v[alist.get(0)] = true;
        //정점 카운팅
        cnt++;

        while (!q.isEmpty()) {
            //시작정점
            int start = q.poll();
            //시작정점의 인접리스트를 돌면서
            for(int vertex : adjList[start]) {
                //방문하지 않았고, 나와 연결된 지역에 같은 선거구가 속해있다면
                if(!v[vertex] && alist.contains(vertex)) {
                    //그 정점(선거구)는 방문처리를 해주고, 카운팅을 하고 큐에 넣는다.
                    v[vertex] = true;
                    cnt++;
                    q.add(vertex);
                }
            }
        }
        //원래 골랐던 팀 사이즈와 정점 카운팅 개수가 같으면 신장트리 이룸. true 리턴
        return cnt == size;
    }

}
