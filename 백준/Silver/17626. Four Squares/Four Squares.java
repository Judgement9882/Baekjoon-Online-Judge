import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		if(N<4) dp[N] = N;
		else {
		/*
		 * 1 2 3 -> 1 2 3
		 * 4 5 6 7 -> 1 2 3 4
		 * 8(4+4) -> 2
		 * 9 -> 1
		 * 10 11 12 -> 2 3 4
		 * 13(9+4) -> 2
		 * 
		 * 13의 경우 
		 * 1+dp[12], 1+dp[9], 1+dp[4] 중에 가장 작은 수 채택 
		 * 
		 * 16의 경우
		 * 1+dp[15], 1+dp[12], 1+dp[7], 1+dp[0] 중 가장 작은수 선택
		 * 1 + dp[i-j*j]
		 */
		
		dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 3;
		for(int i = 4; i <= N; i++) {
			int num = Integer.MAX_VALUE;
			for(int j = 1; j * j <= i; j++) { // 제곱수를 빼서 비교
				num = Math.min(num, dp[i-j*j]); 
			}
			dp[i] = num+1;
		}
		}
		System.out.println(dp[N]);
		
//		System.out.println(sb);
		br.close();
	}
}