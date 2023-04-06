import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		System.out.println(nCr(N, R, 1_000_000_007));
		br.close();
	}
	
	static long nCr(int n, int r, int p) {
		if(r == 0) return 1;
		long[] fac = new long[n+1];
		fac[0] = 1;
		for(int i = 1; i<= n; i++) {
			fac[i] = fac[i-1]*i % p;
		}
		// 5C2 의 경우 5!(2! 3!)^(p-2) % p 라서
		// 5! % p * (2!)^(p-2) % p * (3!)^(p-2) % p 한 뒤 그 결과를 %p
		return (fac[n] * power(fac[r], p-2, p) % p * power(fac[n-r], p-2, p) % p) % p;
		
	}
	
	static long power(long x, long y, long p) {
		long res = 1L;
		x = x%p;
		while(y > 0) {
			if(y%2==1) res = (res*x)%p; // 홀수 차수면 res를 한번더 곱하고 모듈러
			y = y >> 1; // 지수 차수
			x = (x*x) % p; // 나머지는 제곱 진행
		}
		return res;
	}
}