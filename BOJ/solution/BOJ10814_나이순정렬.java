package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ10814_나이순정렬 {
    static int N;
    static class Member {
        int order;
        int age;
        String name;

        @Override
        public String toString() {
            return "Member{" +
                    "order=" + order +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Member(int order, int age, String name) {
            super();
            this.order = order;
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            members[i] = new Member(i, Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age - o2.age < 0) {
                    return -1;
                } else if(o1.age == o2.age) {
                    return o1.order - o2.order;
                }
                return 1;
            }
        });

        for(Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.println(sb);
    }
}
