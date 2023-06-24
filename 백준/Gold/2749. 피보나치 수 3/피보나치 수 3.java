import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = 1000000; // K=6
		int P = 15 * (M/10); // 15 * 100000
		long [] dp = new long[P+1]; 
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i <= P; i++) {
			dp[i] = ((dp[i-1] % M) + (dp[i-2] % M)) % M;
		}
		
		System.out.println(dp[(int) (Long.parseLong(br.readLine())%P)]);
		
		br.close();
	}
}

/*
 *  피사노 주기 (Pisano Period)
 * 
 * 	피보나치 수를 K로 나눈 나머지는 항상 주기를 가짐.
 * 	주기의 길이가 P이면 N번째 피보나치 수를 M으로 나눈 나머지는 
 *  N%P 번째 피보나치 수를 M으로 나눈 나머지와 같음.
 *  
 *  M=10^K일때 K>2라면 주기는 항상 15x10^(k-1)
 */