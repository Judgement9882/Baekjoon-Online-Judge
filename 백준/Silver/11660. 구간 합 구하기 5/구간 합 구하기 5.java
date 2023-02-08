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
		int [][] sum_arr = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			//sum_arr[i][0] = 0; 
			for(int j = 1; j <= N; j++) {
//				board[i][j] = Integer.parseInt(st.nextToken());
				// 현재값과 이전 인덱스의 누적합을 현재의 누적합으로 갱신
//				sum_arr[i][j] = sum_arr[i][j-1] + board[i][j];
				sum_arr[i][j] = sum_arr[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 좌표 입력
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			for(int i = x1; i <= x2; i++) {
				
				// y1~y2 구간합은 y1을 포함해야 하므로 y1-1까지를 빼서 진행 
				ans += (sum_arr[i][y2] - sum_arr[i][y1-1]);
			}
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
