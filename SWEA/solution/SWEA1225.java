/*
 * SWEA1225. 암호생성기
 */
package solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA1225 {

	static int[] pwd;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String tc;
		pwd = new int[8];
		
		//테케 안받아올때까지
		while((tc = br.readLine()) != null) {
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < pwd.length; i++) {
				pwd[i] = Integer.parseInt(st.nextToken());
			}
			
			
			//출력값 넣고 싶을때
			//bw.write(여기는 string);
			//bw.newLine();
			
		}
		
		
		
		
		
		
		
		
		
		
		

		
//		bw.flush();
//		bw.close();
//		br.close();
		

	}

}
