import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		
		int dp[][] = new int[A.length()+1][B.length()+1];
		
		
		for(int i = 1 ; i <= A.length(); i++) {
			for(int j = 1; j <= B.length(); j++) {
				
				if(A.charAt(i-1) == B.charAt(j-1)) { // 가리키는 문자열이 같을 경우
					dp[i][j] = dp[i-1][j-1] + 1;
					
				}
				else { // 다를 경우 이전의 max 값으로 갱신
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[A.length()][B.length()]);
		
		if(dp[A.length()][B.length()]>0) { // 길이 1 이상일때만
	        int index = dp[A.length()][B.length()]; // 길이 인덱스
	        char[] lcs = new char[index]; // 길이만큼 문자 배열 만들기
//	        lcs[index] = '\u0000'; // Set the terminating character
	 
	        int i = A.length();
	        int j = B.length();
	        while (i > 0 && j > 0) {
	            // A[i], B[j] 가 같으면 해당 문자 선택
	            if (A.charAt(i - 1) == B.charAt(j - 1)) {
	                lcs[index-1] = A.charAt(i - 1);
	                i--;
	                j--;
	                index--;
	            }
	 
	            // 같지 않으면 길이가 더 긴걸 사용해야함. j가 더 길면 i감소, i가 더 길면 j 감소
	            else if (dp[i - 1][j] > dp[i][j - 1]) i--;
	            else j--;
	        }
	 
	        // Print the lcs
	        for (int k = 0; k < dp[A.length()][B.length()]; k++)
	            System.out.print(lcs[k]);
	    
		}
		
		
		
		br.close();
	}
}