import java.io.*;
import java.util.*;
public class Main {
	static int R, C, N;
	static int [] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
//	static char [][] board;
	static int[][] board;
	static ArrayDeque<int[]> list = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
//		if(N >= 5) N %= 8;
		
//		board = new char[R][C];
		board = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String temp = st.nextToken();
			for(int j = 0 ; j < C; j++) {
				if(temp.charAt(j) == 'O') {
					board[i][j] = 3;
				}
			}
		}
		
		int time = 1;
		if(N != 1) {
			N = N%4 + 4; // 2, 3, 4, 5 = 6, 7, 8, 9
			
			while(time++ < N) {
				boolean bombFlag = false;
				for(int i = 0; i < R; i++) {
					for(int j = 0 ; j < C; j++) {
						if(board[i][j] == time) {
							list.offer(new int[] {i, j});
							bombFlag = true;
						}
					}
				}
				
				while(!list.isEmpty()) {
					int cur [] = list.poll();
					int i = cur[0]; int j = cur[1];
					board[i][j] = 0;
					for(int dir = 0; dir < 4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						
						if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
						board[nx][ny] = 0;
					}
				}
				
				if(!bombFlag) { // 폭탄 터졌으면 그냥 넘어감. 안터진 경우
					for(int i = 0; i < R; i++) {
						for(int j = 0 ; j < C; j++) {
							if(board[i][j] == 0) {
								board[i][j] = time+3;
							}
						}
					}
				}
			}
		}
		
		// ans
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(board[i][j] > 0) sb.append('O');
				else sb.append('.');
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}