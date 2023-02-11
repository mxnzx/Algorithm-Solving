/*
 * SWEA1225. 암호생성기
 * 구현 - 자료구조 큐 사용
 */
package solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<>();

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				q.offer(Integer.parseInt(st.nextToken()));
			}

			//for반복문에서 break걸리면 flag를 통해 while문을 빠져나온다.
			boolean flag = true;
			while (flag) {
				//front를 빼고 -n을 해서 다시 넣는다. n++. n이 5가되면 다시 1. -> 1사이클 반복문
				for (int n = 1; n <= 5; n++) {
					int tmp = q.poll() - n;
					if (tmp <= 0) {
						tmp = 0;
						q.offer(tmp);
						flag = false;
						break;
					} else {
						q.offer(tmp);
					}
				}
			}
			//출력
			bw.write("#" + num + " ");
			for (int i :
					q) {
				bw.write(i + " ");
			}
			bw.newLine();
			//큐 비우기
			q.clear();

		}
		br.close();
		bw.flush();
		bw.close();
	}

}
