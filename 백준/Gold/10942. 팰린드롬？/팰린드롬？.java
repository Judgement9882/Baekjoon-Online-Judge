import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// S - E 까지 펠린드롬이면 1, 아니면 0
		int arr[] = new int[N+1];
		int dp[][] = new int[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1; // 홀수
			if(i>1 && arr[i-1] == arr[i]) dp[i-1][i] = 1; // 짝수 
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= N-1; j++) {
				
				// 홀수 ===========================
				int left = i-j;
				int right = i+j;
				
				// 이전수 팰린드롬 + 범위안
				if(left >= 1 && right <= N && dp[left+1][right-1] == 1) {
					// 값이 같아야함
					if(arr[left] == arr[right]) {
						dp[left][right] = 1;		
					}
				}

				// 홀수 ===========================
				
				// 짝수 ===========================
				
				int rright = right+1;
				// 이전수 팰린드롬 + 범위안
				if(left >= 1 && rright <= N && dp[left+1][right] == 1) {
					// 값이 같아야함
					if(arr[left] == arr[rright]) {
						dp[left][rright] = 1;		
					}
				}
				// 짝수 ===========================
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			sb.append(dp[S][E]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}