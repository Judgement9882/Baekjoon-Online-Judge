import java.io.*;
import java.util.*;
public class Main {
	static int N, ans=0;
	static int[] A, B;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		v = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0);
		System.out.println(ans);
		br.close();
	}
	
	static void func(int k) {
		if(k==N) {
			ans = Math.max(ans, calc());
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			B[k] = A[i];
			func(k+1);
			v[i] = false;
		}
	}
	
	static int calc() {
		int ret = 0;
		for(int i = 0; i < N-1; i++) {
			ret += Math.abs(B[i] - B[i+1]);
		}
		return ret;
	}
}