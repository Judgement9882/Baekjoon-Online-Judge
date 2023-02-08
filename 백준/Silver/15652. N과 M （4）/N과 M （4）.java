import java.io.*;
import java.util.*;

public class Main{
	
	static int N, R;
	static StringBuilder sb = new StringBuilder();
	static int [] a;
	static void comb(int cnt, int start) {
		
		if(cnt == R) {
			for(int i = 0; i < cnt; i++) {
				
				sb.append(a[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i <= N; i++) {
			a[cnt] = i;
			comb(cnt+1, i);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		a = new int[R];
		comb(0, 1);
		
		System.out.println(sb);
	}
}
