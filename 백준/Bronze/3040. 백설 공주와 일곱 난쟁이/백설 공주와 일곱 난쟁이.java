import java.io.*;
import java.util.*;
public class Main{
	static int N = 9, R = 7;
	static int [] a = new int[N], b = new int[R];
	
	static void comb(int cnt, int start, int sum) {
		
		if(cnt == R) {
			if(sum == 100) {
				for(int i = 0 ; i < R; i++) {
					System.out.println(b[i]);
				}
				
				System.exit(0);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			b[cnt] = a[i];
			comb(cnt+1, i+1, sum + a[i]);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0, 0);
		
		br.close();
	}
}
