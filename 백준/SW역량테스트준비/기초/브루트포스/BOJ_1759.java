import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 	BOJ # 1759 암호 만들기
 * */
public class BOJ_1759 {
	static int L, C;	// L: 선택해야 하는 알파벳 수, C: 선택 가능한 알파벳 수
	static char[] alpha;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<C;i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);	// 사전순 배열
		
		comb(0,new char[L], 0);
		System.out.println(sb);
	}
	// 해당 문자가 모음인지 판별하는 함수 
	static boolean isVowel(char c) {
		if(c=='a' || c=='e' || c=='i'|| c=='o'|| c=='u')
			return true;
		return false;
	}
	// C 개 중 L개 선택하는 조합
	static void comb(int toSelect, char[] selected, int startIdx) {
		if(toSelect==L) {
			int vowel = 0, consonant = 0;
			StringBuilder tmp = new StringBuilder();
			for(int i=0;i<L;i++) {
				char c = selected[i];
				tmp.append(c);
				if(isVowel(c))
					vowel++;
				else
					consonant++;
			}
			//최소 조건
			if(vowel>=1 && consonant>=2)
				sb.append(tmp).append("\n");
			
			return;
		}
		for(int i=startIdx;i<C;i++) {
			selected[toSelect] = alpha[i];
			comb(toSelect+1, selected, i+1);
		}
	}
}
