import java.io.*;
import java.util.*;
public class Main {
	static int [] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int board[][] = new int[10][10];
		int start[] = new int[2];
		for(int i = 0 ; i < 10; i++) {
			String temp = br.readLine();
			for(int j = 0; j < 10; j++) {
				if(temp.charAt(j) == 'B') {
					start[0] = i;
					start[1] = j;
				}
				else if (temp.charAt(j) == 'R') {
					board[i][j] = -1; // 못 감
				} 
				else if (temp.charAt(j) == 'L') {
					board[i][j] = -2; // 도착
				}
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start[0], start[1]});
//		board[start[0]][start[1]] = -1;
		int ans = 0;
		
		end : while(!q.isEmpty()) {
			int cur [] = q.poll();
			for(int dir = 0  ; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
				if(board[nx][ny] == -2) {
					ans = board[cur[0]][cur[1]];
					break end;
				}
				if(board[nx][ny] != 0) continue;
				q.offer(new int[] {nx, ny});
				board[nx][ny] = board[cur[0]][cur[1]] + 1;
			}
		}
//		for(int i = 0 ; i < 10; i++) {
//			for(int j = 0; j < 10; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(ans);
		br.close();
	}
}