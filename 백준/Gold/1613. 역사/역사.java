import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		final int INF = Integer.MAX_VALUE/2;
		int[][] dp = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i==j) continue;
				dp[i][j] = INF;
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[a][b] = 1;
			dp[b][a] = 2;
		}
//		System.out.println("before floyd");
//		printTest(N, dp, INF);
		// floyd
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(k==i) continue;
				for(int j = 1; j <= N; j++) {
					if(k==j || i==j) continue;
					if(dp[i][k]==1 && dp[k][j] == 1) dp[i][j] = 1;
					if(dp[i][k]==2 && dp[k][j] == 2) dp[i][j] = 2;
				} 
			}
		}
//		System.out.println("after floyd");
		// ans
		int S = Integer.parseInt(br.readLine());		
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(dp[a][b] ==INF && dp[b][a] == INF) sb.append("0\n");
			else if(dp[a][b] == 2) sb.append("1\n");
			else if (dp[a][b] == 1) sb.append("-1\n");
		}
//		printTest(N, dp, INF);
		System.out.println(sb);
		br.close();
	}
	
	static void printTest(int N, int[][] dp, int INF) {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				System.out.print(dp[i][j]==INF?-1 + "  ":dp[i][j] + "   ");
			} 
			System.out.println();
		}
	}
}