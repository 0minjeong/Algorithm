import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
	static int N, S;
	static int[] numbers;
	static int total = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		subset(0, new boolean[N]);
		if(S == 0)
			System.out.println(total-1);
		else
			System.out.println(total);
	}
	static void subset(int cnt, boolean[] visited) {
		if(cnt == N) {
			int sum = 0;
			for(int i =0;i<N;i++) {
				if(visited[i]) {
					sum += numbers[i];
				}
			}
			if(sum == S) total++;
			return;
		}
		visited[cnt] = true;
		subset(cnt+1, visited);
		visited[cnt] = false;
		subset(cnt+1, visited);
	}
}
