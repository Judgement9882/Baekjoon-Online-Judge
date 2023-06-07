import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[] {a, b});
		}
		
		// A -> B 까지 최소 연산 횟수
		int [][] dp = new int [N][N];
		for(int i = 1; i <= N-1; i++) { // 연산 길이
			for(int j = 0; j < N-i; j++) { // 시작 위치
				dp[j][j+i] = Integer.MAX_VALUE; // 맥스값으로 초기화
				
				// 해당 회차 i 길이의 연산에서 최솟값 찾기
				for(int k = 0; k <= i-1; k++) { 
					// 시작 위치의 N = j[0]
					// 중간 위치의 M = j+k[1]
					// 끝 위치 K = j+i[1]
					int temp = list.get(j)[0] * list.get(j+k)[1] * list.get(j+i)[1];
					
					// 이전단계에서 계산한 dp[j][j+k], dp[j+k+1][j+i], temp를 더해서 최솟값 갱신
					dp[j][j+i] = Math.min(dp[j][j+i], dp[j][j+k]+dp[j+k+1][j+i]+temp);
				}
			}
		}
		
		System.out.println(dp[0][N-1]);
		br.close();
	}
}