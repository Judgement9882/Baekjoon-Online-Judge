import java.io.*;
import java.util.*;

public class Main { // should change Main

	static int N, M;
	static int[][] board;
	
	// 범위 안에 있을 경우 true를 반환합니다.
	static boolean checkRange(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 입력
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 구현
		int ans = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M ; j++) {
				// 1. 직사각형
				if(checkRange(i+1, j+1)) {
					ans = Math.max(ans, board[i][j] + board[i+1][j] + board[i][j+1] + board[i+1][j+1]);
				}
				
				// 2. 길쭉이(가로)
				if(checkRange(i, j+3)) {
					ans = Math.max(ans, board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3]);
				}
				
				// 3. 길쭉이(세로)
				if(checkRange(i+3, j)) {
					ans = Math.max(ans, board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j]);
				}
				
				// 4. ㄴ자 - 1번
				if(checkRange(i+2, j+1)) {
					ans = Math.max(ans, board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j+1]);
				}				
				
				// 5. ㄴ자 - 2번
				if(checkRange(i-1, j+2)) {
					ans = Math.max(ans, board[i][j] + board[i][j+1] + board[i][j+2] + board[i-1][j+2]);
				}
				
				// 6. ㄴ자 - 3번
				if(checkRange(i+1, j-2)) {
					ans = Math.max(ans, board[i][j] + board[i][j-1] + board[i][j-2] + board[i+1][j-2]);
				}
				
				// 7. ㄴ자 - 4번
				if(checkRange(i-2, j-1)) {
					ans = Math.max(ans, board[i][j] + board[i-1][j] + board[i-2][j] + board[i-2][j-1]);
				}
				
				// 8. ㄴ자 - 1번 반대
				if(checkRange(i+2, j-1)) {
					ans = Math.max(ans, board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j-1]);
				}				
				
				// 9. ㄴ자 - 2번 반대
				if(checkRange(i+1, j+2)) {
					ans = Math.max(ans, board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+2]);
				}
				
				// 10. ㄴ자 - 3번 반대
				if(checkRange(i-1, j-2)) {
					ans = Math.max(ans, board[i][j] + board[i][j-1] + board[i][j-2] + board[i-1][j-2]);
				}
				
				// 11. ㄴ자 - 4번 반대
				if(checkRange(i-2, j+1)) {
					ans = Math.max(ans, board[i][j] + board[i-1][j] + board[i-2][j] + board[i-2][j+1]);
				}
				
				// 12. 계단 - 1번 
				if(checkRange(i+2, j+1)) {
					ans = Math.max(ans, board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1]);
				}
				
				// 13. 계단 - 2번
				if(checkRange(i-1, j+2)) {
					ans = Math.max(ans, board[i][j] + board[i][j+1] + board[i-1][j+1] + board[i-1][j+2]);
				}
				
				// 14. 계단 - 3번
				if(checkRange(i+2, j-1)) {
					ans = Math.max(ans, board[i][j] + board[i+1][j] + board[i+1][j-1] + board[i+2][j-1]);
				}
				
				// 15. 계단 - 4번
				if(checkRange(i+1, j+2)) {
					ans = Math.max(ans, board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2]);
				}
				
				// 16. ㅜ 
				if(checkRange(i+1, j+1) && checkRange(i, j+2)) {
					ans = Math.max(ans, board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+1]);
				}
				
				// 17. ㅓ
				if(checkRange(i+2, j) && checkRange(i+1, j-1)) {
					ans = Math.max(ans, board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j-1]);
				}
				
				// 18. ㅗ
				if(checkRange(i, j-2) && checkRange(i-1, j-1)) {
					ans = Math.max(ans, board[i][j] + board[i][j-1] + board[i][j-2] + board[i-1][j-1]);
				}
				
				// 19. ㅏ
				if(checkRange(i-2, j) && checkRange(i-1, j+1)) {
					ans = Math.max(ans, board[i][j] + board[i-1][j] + board[i-2][j] + board[i-1][j+1]);
				}
				
			}
		}
		
		
		System.out.println(ans);
	}

}
