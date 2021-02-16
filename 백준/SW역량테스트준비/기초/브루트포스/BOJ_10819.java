import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10819 {
	static int[] answer;
	static int[] numbers;
	static int N;
	static int max; 
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		String s[] = in.readLine().split(" ");
		numbers = new int[N];
		max = 0;
		
		for(int i = 0;i<N;i++) {
			numbers[i] = Integer.parseInt(s[i]);
		}
		permutation(0,new int[N], new boolean[N]);
		System.out.println(max);
	
	}
	
	static void permutation(int toSelect, int[] selected, boolean[] visited) {
		if(toSelect == N) {
			int sum = 0;
			for(int i=1;i<N;i++) {
				sum += Math.abs(selected[i]- selected[i-1]);
			}
			if(max<sum) {
				max = sum;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[toSelect] = numbers[i];
				permutation(toSelect+1, selected, visited);
				visited[i] = false;
			}
		}
	}
}
