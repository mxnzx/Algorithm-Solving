package solution;

import java.util.*;
import java.io.*;

public class BOJ10825_국영수 {

    static class Student implements Comparable<Student> {
        String name;
        int koScore;
        int enScore;
        int mathScore;

        Student(String name, int koScore, int enScore, int mathScore) {
            this.name = name;
            this.koScore = koScore;
            this.enScore = enScore;
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student o) {
            if(this.koScore == o.koScore) {
                if(this.enScore == o.enScore) {
                    if(this.mathScore == o.mathScore) {
                        return this.name.compareTo(o.name);
                    }
                    return o.mathScore - this.mathScore;
                }
                return this.enScore - o.enScore;
            }
            return o.koScore - this.koScore;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            students[i] = new Student(n, k, e, m);
        }

        Arrays.sort(students);

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            ans.append(students[i].name);
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
