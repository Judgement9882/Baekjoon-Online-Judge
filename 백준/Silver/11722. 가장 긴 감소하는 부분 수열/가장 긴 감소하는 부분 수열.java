import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int [] A = new int[N+1];
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int [] dp = new int[N+1];
		for(int i = 1; i<= N; i++) {
			dp[i] = 1;
			for(int j = 1; j <= i-1; j++) {
				if(A[j] > A[i] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		int max_num = 0;
		for(int lis : dp) max_num = Math.max(max_num, lis);
		System.out.println(max_num);
		br.close();
	}
}