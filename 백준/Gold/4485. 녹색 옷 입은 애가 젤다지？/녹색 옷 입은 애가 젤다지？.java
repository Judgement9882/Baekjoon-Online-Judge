import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static int [][] board, copy_board;
	static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static int bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0}); // 처음 위치
		copy_board[0][0] = board[0][0];
		// copy_board는 중간 값 저장
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int x = cur[0];
			int y = cur[1];
			for(int dir= 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				// 범위 이탈
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if( copy_board[nx][ny] > copy_board[x][y] + board[nx][ny]) {
					copy_board[nx][ny] = copy_board[x][y] + board[nx][ny];
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		return copy_board[N-1][N-1];
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		while(++tc > 0) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			board = new int[N][N];
			copy_board = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					copy_board[i][j] = Integer.MAX_VALUE;
				}
			}
			
			ans = bfs();
			
			sb.append("Problem ").append(tc).append(": ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}