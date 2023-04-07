package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759_암호만들기 {

	static int L, C;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 한개의 모음 + 두개의 자음은 일단 뽑아야 함 -> 뽑고 시작? -> 아님 하고 걸러? 하고거르자
		// C개 중에 L개를 뽑는데 오름차순으로만 가능 -> 그럼 정렬을하고 뽑자?
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);	//오름차순으로 뽑아야 하니 정렬을 해놓고 조합으로 고른다
		//조합으로 고르자
		comb(0,0, new char[L]);
		System.out.println(sb);
	}
	
	//원본배열 인덱스: idx  선택배열 인덱스: k 
	private static void comb(int idx, int k, char[] sel) {
		if(k == sel.length) {
			if(check(sel)) {
				for(char c : sel) sb.append(c);
				sb.append("\n");
				return;
			}
			return;
		}
		
		//다 뽑고 거르자
		for(int i=idx;i<C;i++) {
			sel[k] = arr[i];
			comb(i+1, k+1, sel);
		}
	}

	private static boolean check(char[] sel) {
		boolean vow=false, cons=false;
		int cnt=0;
		for(char c: sel) {
			if(vow && cons) return true;
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vow = true;
			}
			else {
				cnt++;
				if(cnt >= 2) cons = true;
			}
		}
		if(vow && cons) return true;
		return false;
	}

}
