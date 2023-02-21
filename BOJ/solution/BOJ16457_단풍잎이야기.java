package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16457_단풍잎이야기 {
    static int n,m,k, Ans;
    static int[][] arr;
    static int[] key;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //키 개수
        m = Integer.parseInt(st.nextToken());   //퀘스트 수
        k = Integer.parseInt(st.nextToken());   //스킬 개수

        Ans = 0;
        key = new int[2*n+1]; //필요한 키 배열 생성
        arr = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                key[arr[i][j]]++;
            }
        }
        //뽑힌 스킬값만 따로 리스트
        list = new ArrayList<>();
        for (int i = 0; i < key.length; i++) {
            if(key[i]>0)
                list.add(i);
        }
        pick(new int[n],0,0);
        //출력
        System.out.println(Ans);

    }

    private static void pick(int[] sel, int idx, int v) {


        if(v == sel.length) {
            //퀘스트 수행 개수 비교 -> 퀘스트를 몇개까지 클리어 할 수 있는지 방문배열로 체크
            //System.out.println(Arrays.toString(sel));
            //조합으로 데려온 애들만 방문배열 true
            boolean[] visited = new boolean[2*n+1];
            for (int i: sel) {
                visited[i] = true;
            }

            int tmpMax=0;
            //퀘스트 개수만큼 반복
            for (int j = 0; j < m ; j++) {
                int cnt=0;  //한 퀘스트에서 필요한 키 다 있는지 셀때 사용하는 변수
                for (int l = 0; l < k ; l++) {
                    if(visited[arr[j][l]]) cnt++;
                }
                //카운트가 k가 다 있으면 템프 업
                if(cnt == k) tmpMax++;
            }
            //Ans = Math.max(Ans, tmpMax);
            if(tmpMax > Ans) Ans = tmpMax;
            return;
        }
        //더 이상 고를 값이 없을 경우
        if(idx == list.size()) {
            System.out.println(Arrays.toString(sel));
            return;
        }

            //뽑는경우
        sel[v] = list.get(idx);
        //System.out.println(Arrays.toString(sel));
        pick(sel,idx+1,v+1);
        //안뽑는경우
        pick(sel, idx+1,v);
    }
}
