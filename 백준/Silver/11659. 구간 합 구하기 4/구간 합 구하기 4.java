import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 테스트케이스
		
		// 인덱스 1부터 시작
//		int [][] board = new int[N+1][N+1];
		int [] sum_arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			// 현재값과 이전 인덱스의 누적합을 현재의 누적합으로 갱신
			sum_arr[i] = sum_arr[i-1] + Integer.parseInt(st.nextToken());
			
		}
		
		for(int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 좌표 입력
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			int ans = 0;
				
				// i~j 구간합은 i을 포함해야 하므로 i-1까지를 빼서 진행 
			ans = sum_arr[j] - sum_arr[i-1];
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
