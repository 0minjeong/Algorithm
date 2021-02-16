import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	BOJ # 10972 다음 순열
 * */
public class BOJ_10972 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int i=N-1;	//교환할 위치
		while(i>0 && num[i-1]>num[i]) i--;
		if(i==0) {
			System.out.println(-1);
			return;
		}
		
		int j= N-1;
		while(j>0&& num[i-1]>num[j]) j--;
		
		swap(num,i-1,j);
		
		int k = N-1;
		while(i<k) {
			swap(num, i++,k--);
		}
		
		for(int n: num) {
			System.out.print(n+" ");
		}
	}
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
