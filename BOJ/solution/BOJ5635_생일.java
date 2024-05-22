package solution;

import java.util.*;
import java.io.*;

public class BOJ5635_생일 {

    static class Student implements Comparable<Student> {
        String name;
        int year;
        int month;
        int day;

        Student(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo(Student o) {
            if(this.year == o.year) {
                if(this.month == o.month) {
                    return this.day - o.day;
                }
                return this.month - o.month;
            }
            return this.year - o.year;
        }
    }

    static Student[] students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        students = new Student[n];
        for(int i= 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, y, m, d);
        }

        Arrays.sort(students);

        System.out.println(students[n-1].name);
        System.out.println(students[0].name);
    }
}
