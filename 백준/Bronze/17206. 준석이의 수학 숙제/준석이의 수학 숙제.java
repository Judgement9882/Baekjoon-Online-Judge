import java.util.*;
import java.io.*;
public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 미리 8만개의 수의 값 구하기
		int [] dp = new int[80_001];
		for(int i = 1 ; i <= 80_000; i++) {
			if(i % 3 == 0 || i % 7 == 0) {
				dp[i] = dp[i-1] + i;
			}
			else {
				dp [i] = dp [i-1];
			}
			
		}
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < T; i++) {
			int N = Integer.parseInt(st.nextToken());
			System.out.println(dp[N]);
		}
		br.close();
	}
}