/*
 * n개 중에 n개를 뽑아내는 순열 문제이다. 
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	int  x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

public class SWEA1247 {

	static StringBuffer sb = new StringBuffer();
	static int Ans, T, num;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			num = Integer.parseInt(br.readLine()); //고객 수
			
			st = new StringTokenizer(br.readLine());
			
			Point[] cus = new Point[num];
			Point company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
			Point house = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
			for (int i = 0; i < num; i++) {
				cus[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
			}
			//-------------------입력------------------------------------------------------------------------
			
			permutation(cus, new Point[cus.length],new boolean[cus.length], 0, company, house);

			sb.append("#").append(tc).append(" ").append(Ans).append("\n");

		}

	}
	private static void permutation(Point[] cus, Point[] sel, boolean[] v, int k, Point company, Point house) {
		//  basis part
		if(k==sel.length) {
			
			System.out.println(Arrays.toString(sel));
			
			int c = Math.abs(company.x - sel[0].x) + Math.abs(company.y- sel[0].y);
			int h = Math.abs(sel[sel.length-1].x - house.x) + Math.abs(sel[sel.length-1].y - house.y);
			int sum = 0;
			for(int i = 0; i < num-1; i++) {
				sum += Math.abs(sel[i].x - sel[i+1].x) + Math.abs(cus[i].y- cus[i+1].y);
			}
			Ans = Math.min(Ans, c+h+sum);
			return;
		}
		
		//  inductive part
		
		for (int i = 0; i < cus.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = cus[i];
				permutation(cus, sel, v, k+1, company, house);
				v[i] = false;
			}
			
		}
	}

}
