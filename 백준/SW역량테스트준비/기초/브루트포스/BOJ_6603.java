import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603 {
	static StringBuilder sb;
	static int k;
	static int m = 6;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = "";
		while(!(s=in.readLine()).equals("0")) {
			st = new StringTokenizer(s, " ");
			k = Integer.parseInt(st.nextToken());	// k개
			numbers = new int[k];					// 숫자 집합
			
			//init number
			for(int i=0;i<k;i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			// 조합
			sb = new StringBuilder("");
			combination(0,new int[m],0);
			System.out.println(sb);
		}
		
	}
	static void combination(int toSelect, int[] selected, int startIdx) {
		if(toSelect == m) {
			for(int i=0;i<m;i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=startIdx;i<k;i++) {
			selected[toSelect] = numbers[i];
			combination(toSelect+1, selected, i+1);
		}
	}
}
