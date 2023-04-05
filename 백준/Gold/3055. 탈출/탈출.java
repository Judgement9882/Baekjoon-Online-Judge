import java.io.*;
import java.util.*;
public class Main {
	static int R, C, desX, desY;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] Gmap, Wmap;
	
	static char[][] board;
	static ArrayDeque<int[]> water = new ArrayDeque<>();
	static ArrayDeque<int[]> gosum = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		Gmap = new int[R][C];
		Wmap = new int[R][C];
		
		// 도착지 : -1
		// 갈 수 없는 곳 : -2
		// 출발지 : 1
		for(int i = 0; i < R; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < C; j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j] == 'D') {
					Gmap[i][j] = Wmap[i][j] = -1;
					desX = i; desY = j;
				}
				else if (board[i][j] == 'S') {
					Gmap[i][j] = 1;
					gosum.offer(new int[] {i, j});
				}
				else if (board[i][j] == '*') {
					Wmap[i][j] = 1;
					Gmap[i][j] = -1;
					water.offer(new int[] {i, j});
				}
				else if (board[i][j] == 'X') {
					Gmap[i][j] = Wmap[i][j] = -2;
				}
			}
		}
		
		// 물 bfs
		while(!water.isEmpty()) {
			int cur [] = water.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(Wmap[nx][ny] != 0) continue;
				Wmap[nx][ny] = Wmap[cur[0]][cur[1]]+1;
				water.offer(new int[] {nx, ny});
			}
		}
		
		// 고슴도치 bfs
		while(!gosum.isEmpty()) {
			int cur [] = gosum.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(Gmap[nx][ny] != 0) continue;
				Gmap[nx][ny] = Gmap[cur[0]][cur[1]]+1;
				gosum.offer(new int[] {nx, ny});
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int d = 0; d < 4; d++) {
			int nx = desX + dx[d];
			int ny = desY + dy[d];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if(Gmap[nx][ny] == 0 || Gmap[nx][ny] == -1) continue; // 고슴도치가 못갔으므로 고려x
			if(Gmap[nx][ny] < (Wmap[nx][ny]==0?Integer.MAX_VALUE:Wmap[nx][ny])) { // 물보다 빨리 도달했다면
				ans = Math.min(ans,  Gmap[nx][ny]);
			}
		}
		System.out.println(ans==Integer.MAX_VALUE?"KAKTUS":ans);
		
		br.close();
	}
}