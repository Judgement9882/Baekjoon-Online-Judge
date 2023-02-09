import java.io.*;
import java.util.*;

public class Main{
	static int cnt_A = 0, cnt_C = 0, cnt_G = 0, cnt_T = 0;
	
	// 알파벳과 1(+), 0(-1) 을 받아 A, C, G, T 의 개수를 갱신하는 함수
	static void checkAlphabet(char ch, boolean opt) {
		if(opt) {
			if(ch=='A') cnt_A++;
			else if(ch=='C') cnt_C++;
			else if(ch=='G') cnt_G++;
			else if(ch=='T') cnt_T++;
		}
		else {
			if(ch=='A') cnt_A--;
			else if(ch=='C') cnt_C--;
			else if(ch=='G') cnt_G--;
			else if(ch=='T') cnt_T--;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 문자열의 길이와 비밀번호 자리수
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		// DNA 문자열 입력
		st = new StringTokenizer(br.readLine(), " ");
		String pw = st.nextToken();
		
		// 문자 개수 입력
		st = new StringTokenizer(br.readLine(), " ");
		int An = Integer.parseInt(st.nextToken());
		int Cn = Integer.parseInt(st.nextToken());
		int Gn = Integer.parseInt(st.nextToken());
		int Tn = Integer.parseInt(st.nextToken());
		
		// 예외  : 필요 문자 개수가 비밀번호 자리수보다 많음
		if(An+Cn+Gn+Tn > P) System.out.println("0");
		
		// 진행
		else {
			int ans = 0;
			
			for(int i = 0; i < P; i++) {
				checkAlphabet(pw.charAt(i), true);
			}	
			int start = 0;
			int end = P;
			while(true) {
				if(cnt_A >= An && cnt_C >= Cn && cnt_G >= Gn && cnt_T >= Tn) ans++;
				
				// 마지막이면 종료
				if(end == S) break;
				
				// start의 값은 빼고 end의 값을 증가시킴
				checkAlphabet(pw.charAt(start++), false);
				checkAlphabet(pw.charAt(end++), true);
			}
			System.out.println(ans);
		}
		
	}
}
