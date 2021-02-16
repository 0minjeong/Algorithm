import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*	
 * 	BOJ # 1476 날짜 계산
 * */
public class BOJ_1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int e = 1, s = 1, m = 1;
		int year = 1;
		
		while (true) {
			if(e == E && s == S && m == M) {
				break;
			}
			year++;
			e = (year-1) % 15 + 1;
			s = (year-1) % 28 + 1;
			m = (year - 1) % 19 + 1;
		}
		
		System.out.println(year);
	}

}
