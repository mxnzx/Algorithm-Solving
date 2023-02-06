package solution;

import java.util.Scanner;

public class BOJ17478 {
    static String bar = "____";
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        int n = 0;

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursive(n, repeat);

    }

    public static void recursive(int n, int repeat) {
        // basis part
        if (n == repeat) {
            System.out.println(sb + "\"재귀함수가 뭔가요?\"\n"
                    + sb + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"
                    + sb + "라고 답변하였지.");
            return;
        }
        // inductive part
        System.out.println(sb + "\"재귀함수가 뭔가요?\"\n"
                + sb + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
                + sb + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
                + sb + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        sb.append(bar);
        recursive(n + 1, repeat);
        sb.delete(0, 4);
        System.out.println(sb + "라고 답변하였지.");

    }

}
