import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();
		
		int dp[][][] = new int[A.length()+1][B.length()+1][C.length()+1];
		
		
		for(int i = 1 ; i <= A.length(); i++) {
			for(int j = 1; j <= B.length(); j++) {
				for(int k = 1; k <= C.length(); k++) {
					if(A.charAt(i-1) == B.charAt(j-1) && B.charAt(j-1) == C.charAt(k-1)) { // 가리키는 문자열이 같을 경우
						dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
						
					}
					else { // 다를 경우 이전의 max 값으로 갱신
						dp[i][j][k] = Math.max(dp[i][j][k-1], Math.max(dp[i-1][j][k], dp[i][j-1][k]));
					}	
				}
			}
		}
		System.out.println(dp[A.length()][B.length()][C.length()]);
		
		
		br.close();
	}
}