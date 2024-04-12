package solution;

import java.io.*;
import java.util.*;

public class BOJ1713_후보추천하기 {
    static class Person {
        int idx;
        int createdAt;
        int recommandCnt;

        Person(int idx, int recommandCnt, int createdAt) {
            this.idx = idx;
            this.recommandCnt = recommandCnt;
            this.createdAt = createdAt;
        }

        int getRecommandCnt() {
            return this.recommandCnt;
        }

        int getCreatedAt() {
            return this.createdAt;
        }
    }
    static Person[] frame;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //사진 틀 수
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        frame = new Person[N];
        for(int i=0; i<M; i++) {
            int n = Integer.parseInt(st.nextToken());
            Person p = new Person(n, 1, i);
            // 사진틀에 본인이 있는지 체크 - 있다면 추천수 증가 후 다음 턴으로 이동
            if(checkExist(n)) continue;
            // 사진틀에 넣을 수 있는지 체크
            int putIdx;
            if((putIdx = checkEmpty()) >= 0) {
                frame[putIdx] = p;
            } else {
                Arrays.sort(frame, Comparator.comparing(Person::getRecommandCnt)
                                            .thenComparing(Person::getCreatedAt));
                frame[0] = p;
            }
        }
        printAnswer();
    }
    private static void printAnswer() {
        StringBuilder answer = new StringBuilder();
        List<Integer> resultStudent = new ArrayList<>();
        for(int i=0; i< frame.length; i++) {
            if(frame[i] != null) {
                resultStudent.add(frame[i].idx);
            }
        }
        Collections.sort(resultStudent);
        for(int n : resultStudent) {
            answer.append(n).append(" ");
        }
        System.out.println(answer);
    }

    private static int checkEmpty() {
        for(int i=0;i< frame.length; i++) {
            if(frame[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private static boolean checkExist(int n) {
        for(Person p : frame) {
            if(p != null && p.idx == n) {
                p.recommandCnt++;
                return true;
            }
        }
        return false;
    }
}
