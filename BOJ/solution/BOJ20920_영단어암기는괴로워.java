package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20920_영단어암기는괴로워 {
    static class MyWord {
        String word;
        int cnt;

        MyWord(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

    }
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        /*
        1. 빈도 수
        2. 단어 길이
        3. 사전 순(오름차순)
        compare 재정의. 클래스 하나 만들기
         */
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() < M) continue;
            if(dict.containsKey(word)) {
                int cnt = dict.get(word);
                dict.put(word, cnt+1);
            } else {
                dict.put(word, 1);
            }
        }
        // MyWord 로 새로 만든다
        MyWord[] myDict = new MyWord[dict.size()];
        int n=0;
        for(String key : dict.keySet()) {
            int cnt = dict.get(key);
            myDict[n++] = new MyWord(key, cnt);
        }
        Arrays.sort(myDict, (o1, o2) -> {
            if(o1.cnt == o2.cnt) {
                if(o1.word.length() == o2.word.length()) {
                    return o1.word.compareTo(o2.word);
                } else {
                    return o2.word.length() - o1.word.length();
                }
            } else {
                return o2.cnt - o1.cnt;
            }
        });
        StringBuilder sb= new StringBuilder();
        for(MyWord mw : myDict) {
            sb.append(mw.word).append("\n");
        }
        System.out.println(sb);
    }
}
