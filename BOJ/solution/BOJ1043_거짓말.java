package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1043_거짓말 {
    static int N, M;
    static int[] parents;
    static boolean[] knowTruth;
    static ArrayList<Integer>[] party;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //사람수
        M = Integer.parseInt(st.nextToken());   //파티 수

        //알고있는 사람들을 인덱스로 해서 따로 체크해놓는다
        knowTruth = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }


        //make set
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        //파티 정보
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int per = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            party[i].add(a);
            for (int j = 0; j < per-1; j++) {
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
                party[i].add(b);
            }
        }
        //knowTruth와 같이 있는 부모를 찾아 true로 바꾸어 준다
        for (int i = 1; i <= N; i++) {
            if(knowTruth[i]){
                knowTruth[find(i)] = true;
            }
        }

        //파티에 속한 인원 중 부모가 knowTruth가 false이면 cnt 업
        int parent;
        int cnt=0;
        for (int i = 0; i < M; i++) {
            parent = find(party[i].get(0));
            if(!knowTruth[parent]) cnt++;
        }
        System.out.println(cnt);


    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) {
            parents[pb] = parents[pa];
        }
    }

    private static int find(int og) {
        if(parents[og] == og) return og;
        else return parents[og] = find(parents[og]);
    }
}
