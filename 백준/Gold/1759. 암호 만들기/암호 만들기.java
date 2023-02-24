import java.util.*;
import java.io.*;

public class Main{

	static int L, C;
	static char alphabet[];
	static char[] pw;
	static boolean[] isused;
	
	static void comb(int cnt, int start) {
		if(cnt == L) {
			
			int cons_num = 0;
			int noun_num = 0;
			
			for(int i = 0 ; i < L; i++) {
				if(pw[i] == 'a' || pw[i] == 'e' || pw[i] == 'i' || pw[i] == 'o' || pw[i] == 'u') {
					noun_num++;
				}else cons_num++;
			}
			
			if(cons_num >= 2 && noun_num >= 1) {
				for(char ch : pw) System.out.print(ch);
				System.out.println();
			}
			
			return;
		}
		
		for(int i = start; i < C; i++) {
			pw[cnt] = alphabet[i];
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char [C];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		pw = new char[L];
		isused = new boolean[C];
		Arrays.sort(alphabet);
		comb(0, 0);
				
		br.close();
	}
}