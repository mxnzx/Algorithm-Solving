package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1120_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 

		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		int gap = str2.length() - str1.length();
		int cnt=0;
		//맨 앞 or 맨뒤
		
		if(gap == 0) {
			for (int i = 0; i < str1.length(); i++) {
				if(str1.charAt(i) == str2.charAt(i)) cnt++;
			}
		} else checkStr();

	}

	private static void checkStr() {
		// TODO Auto-generated method stub
		
	}

}
