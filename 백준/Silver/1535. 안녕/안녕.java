import java.io.*;
import java.util.*;
public class Main {
	static int N; 
	static int [] hp, pleasure;
	static int [][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//1
		N = Integer.parseInt(br.readLine());
		hp = new int[N+1];
		pleasure = new int[N+1];
		
		//2
		for(int m = 0; m < 2; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				if(m==0)   hp[i] = Integer.parseInt(st.nextToken());
				else pleasure[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N+1][100];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= 99; j++) { // 체력은 1 이상이여야 하니 99까지.
				// 만약 잔여 체력이 적어서 인사할 수 없다면 인사 하지 않음
				// => 이전 값을 유지함
				if(j < hp[i]) {
					dp[i][j] = dp[i-1][j];
				}
				else { // 인사할 수 있음 
					// => 인사한 것 , 인사하지 않은 것중에 최대 기쁨 고르기
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-hp[i]] + pleasure[i]);
				}
			}
		}
		System.out.println(dp[N][99]); 
		br.close();
	}
}