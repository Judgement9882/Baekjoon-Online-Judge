import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] A = new int[n];
		for(int i = 0 ;i < n; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		int [] dp = new int[k+1];
		dp[0] = 1; // 0원은 선택하지 않는 1가지 경우의 수
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= k; j++) {
				// A[i]보다 크거나 같을때 이전 j-A[i]의 값을 더함
				// (될 수 있는 개수 더하기)
				if(j >= A[i]) dp[j] += dp[j-A[i]];
			}
		}
		System.out.println(dp[k]);
		br.close();
	}
}