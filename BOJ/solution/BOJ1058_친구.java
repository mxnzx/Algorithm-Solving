// 로직 부분 for문 돌리면서 방문배열써서 풀수도 있고, HashSet 자료구조를 쓰면 중복값 알아서 제거해주니까 방문배열 쓸 필요가 없어짐
// 근데 둘이 시간과 메모리 차이는 딱히 없다
// 근데 이게 플로이드 워샬 알고리즘으로 분류됨. 나중에 다시 ㄱㄱ
package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class BOJ1058_친구 {
    static int N;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = i; j <= N; j++) {
                char b = str.charAt(j-1);
                if(b == 'Y') {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        //내 연결리스트의 개수 + 내 친구의 친구의 수 => depth=2
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            HashSet<Integer> hs = new HashSet<>();

            for(int n : adjList[i]) {
                hs.add(n);
                for (int m : adjList[n]) {
                    if(i == m) continue;
                    hs.add(m);
                }
            }
            max = Math.max(max, hs.size());
        }
        System.out.println(max);
    }
}
