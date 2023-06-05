import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] colors = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			colors[i][0] = Integer.parseInt(st.nextToken());
			colors[i][1] = Integer.parseInt(st.nextToken());
			colors[i][2] = Integer.parseInt(st.nextToken());
		}
		
		/**
		 *  dp[i][j]
		 *  
		 *  i : N번째 집을 칠 할 차례 
		 *  j : 해당 색깔을 칠할 때 이전으로 올 수 있는 수의 최소
		 */
		int INF = 1004;
		int ans = Integer.MAX_VALUE;
		
		int [][] dp = new int[N][3];
		
		// 첫번째가 빨강
		dp[0][0] = colors[0][0];
		dp[0][2] = dp[0][1] = INF;
		for(int i = 1; i < N; i++) {
			dp[i][0] = colors[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = colors[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = colors[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		ans = Math.min(ans, Math.min(dp[N-1][1], dp[N-1][2]));
		
		// 첫번째가 초록
		dp[0][1] = colors[0][1];
		dp[0][2] = dp[0][0] = INF;
		for(int i = 1; i < N; i++) {
			dp[i][0] = colors[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = colors[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = colors[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		ans = Math.min(ans, Math.min(dp[N-1][0], dp[N-1][2]));
		
		// 첫번째가 파랑
		dp[0][2] = colors[0][2];
		dp[0][0] = dp[0][1] = INF;
		for(int i = 1; i < N; i++) {
			dp[i][0] = colors[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = colors[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = colors[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		ans = Math.min(ans, Math.min(dp[N-1][0], dp[N-1][1]));
		
		System.out.println(ans);
		br.close();
	}
}