import java.io.*;
import java.util.*;

public class Main {
	
	public static int N;
	public static final int MOD = 1234567891;
	
	static int r_pow(int r, int rep) {
		if(rep == 0) return 1;
		
		for(int i = 1; i < rep; i++) {
			r = (r * 31) % MOD;
		}
		return r;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		String temp = st.nextToken();
		for(int i = 0 ; i < N; i++) {
			int num = (int) (temp.charAt(i)) - 96 ;
			ans = (ans + num * r_pow(31, i)) % MOD;
//			System.out.println(ans);
		}
		System.out.println(ans);
	}
}