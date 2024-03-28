package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2822_점수계산 {
    static class Question {
        int idx;
        int score;
        Question(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Question[] score = new Question[8];
        for (int i = 0; i < 8; i++) {
            score[i] = new Question(i+1, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(score, (o1, o2) -> {
            if(o1.score != o2.score) return o2.score - o1.score;
            return o1.idx - o2.idx;
        });
        Question[] result = new Question[5];
        for (int i = 0; i < 5; i++) {
            result[i] = score[i];
        }
        Arrays.sort(result, ((o1, o2) -> {
            return o1.idx - o2.idx;
        }));
        int sum = 0;
        StringBuilder answer = new StringBuilder();
        for(Question q : result) {
            sum += q.score;
            answer.append(q.idx).append(" ");
        }
        answer.insert(0, sum + "\n");
        System.out.println(answer);


    }
}
