/*
 * [BOJ]4779. 칸토어 집합
 * 재귀
 * 막힌 부분: 문자열을 가지고 처리를 하다보니 StringBuilder객체가 계속 생성되어 메모리 초과뜸.
 * 문자열 나오면 배열에 넣어 처리하는 걸 먼저 생각하자 . .
 */
package solution;

import java.io.*;

public class BOJ4779 {
	static char[] chars;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		String n;	// '-' 개수 = 3^n
		int cnt; 	//	'-' 개수

		//EOF
		while((n = br.readLine()) != null) {

			cnt = (int) Math.pow(3,Integer.parseInt(n));
			chars = new char[cnt];
			for (int i = 0; i < cnt; i++) {
				chars[i] = '-';
			}
			recursive(0, cnt);
			for (char c : chars) {
				bw.append(c);
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static void recursive(int start, int length) {

		//basis part
		//자를 문자열의 길이가 3보다 작으면 다 쪼개진 것과 같다
		if (length < 3) {
			return;
		}

		//inductive part
		//가운데 문자열 공백처리
		for (int i = start+length/3; i < start+length/3*2; i++) {
			chars[i] = ' ';
		}

		//현재 기준 왼쪽
		recursive(start, length/3);
		//현재 기준 오른쪽
		recursive(start + length/3*2, length/3);
	}

}
