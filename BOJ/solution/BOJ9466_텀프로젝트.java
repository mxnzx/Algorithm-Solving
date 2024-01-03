package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9466_텀프로젝트 {
    static int n, cnt;
    static int[] students;
    static boolean[] isVisited, isGroup;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            cnt = 0;
            n = Integer.parseInt(br.readLine());
            students = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }
            /*
            사이클을 찾아내는 게 관건임.
            사이클을 검출(detect)하는 방법
            1. union-find : 무방향 그래프에서 사이클을 찾는데 유용
            2. DFS: 그래프의 모든 정점을 엣지 방향따라 순회하면서 백에지가 있으면 사이클이 존재한다.
            이 문제의 핵심은 모든 노드들은 무조건 다른 한 개의 노드를 가리킨다. 라는 조건
            이는 내가 가리킨 학생이 이미 팀을 이뤘으면 나는 팀을 이룰 수 없다. 또 팀을 이루려면 서로를 선택해야 함.
             */
            isVisited = new boolean[n+1];    // 방문 체크
            isGroup = new boolean[n+1];      // 팀 구성 했는지 체크
            for (int i = 1; i <= n; i++) {
                if(!isGroup[i]) dfs(i);
            }
            System.out.println(n-cnt);
        }
    }

    private static void dfs(int current) {
        // 현재 탐색중인 흐름에서 방문을 이미 했다면 사이클 형성된 것임.
        if(isVisited[current]) {
            isGroup[current] = true;
            cnt++;
        } else {    //방문 아직 안했다면 했다고 체크하고 넘어감.
            isVisited[current] = true;
        }
        int next = students[current];
        // 다음 노드가 팀 결성을 했었는지 판단. 안했을 경우만 탐색하고, 아닌 경우는 어차피 사이클을 돌지 못하니 패스.
        if(!isGroup[next]) dfs(next);
        isVisited[current] = false;
        isGroup[current] = true;    // 팀 결성했다고는 체크함.
    }
}
