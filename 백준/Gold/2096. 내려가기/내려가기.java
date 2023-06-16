import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[2][3]; // 최대 0, 최소 1
		
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int third = Integer.parseInt(st.nextToken());
			
			if(i==0) { // 최초에만
				dp[0][0] = dp[1][0] = first;
				dp[0][1] = dp[1][1] = second;
				dp[0][2] = dp[1][2] = third;
			}
			else {
				int temp00 = Math.max(dp[0][0], dp[0][1]) + first; 
				int temp01 = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])) + second;
				int temp02 = Math.max(dp[0][1], dp[0][2]) + third;
				dp[0][0] = temp00;
				dp[0][1] = temp01;
				dp[0][2] = temp02;
				
				int temp10 = Math.min(dp[1][0], dp[1][1]) + first; 
				int temp11 = Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2])) + second;
				int temp12 = Math.min(dp[1][1], dp[1][2]) + third;
				
				dp[1][0] = temp10;
				dp[1][1] = temp11;
				dp[1][2] = temp12;
//				System.out.println(dp[1][0]);
//				System.out.println(dp[1][1]);
//				System.out.println(dp[1][2]);
			}
		}
		int maxN = 0, minN = Integer.MAX_VALUE;
		for(int i = 0 ; i < 3; i++) {
			maxN = Math.max(maxN, dp[0][i]);
			minN = Math.min(minN, dp[1][i]);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(maxN).append(" ").append(minN);
		System.out.println(sb);
		br.close();
	}
}