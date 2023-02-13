/*
 * SWEA1228. 암호문1
 * 어떤 리스트에 있어서 숫자를 받으면 그 뒤로 껴넣는다 -> LinkedList
 */

package solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1228_암호문1 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			//System.out.println(list);

			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String I = st.nextToken();
				int idx = Integer.parseInt(st.nextToken());	//list인덱스 0번부터
				int re = Integer.parseInt(st.nextToken());
				//해당 인덱스 뒤에 숫자를 추가한다. idx는 하나씩 늘려서 넣는다.
				for (int j = 0; j < re; j++) {
					list.add(idx++, Integer.parseInt(st.nextToken()));
				}
			}
			bw.append("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				bw.append(list.get(i) + " ");
			}
			bw.append("\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
		

	}

}
