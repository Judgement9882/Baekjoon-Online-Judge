import java.io.*;
import java.util.*;
public class Main {
	
	static int[][] board;
	static int[] hx = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int K, W, H;
	static boolean[][][] v;
	
	static int bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		board[0][0] = 1;
		v[0][0][0] = true;
		// x, y, k, dist
		q.offer(new int[] {x, y, 0, 1});
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			if(cur[0] == H-1 && cur[1] == W-1) return cur[3]-1;
			
			if(cur[2] < K) {
				for(int h = 0; h < 8; h++) {
					int nx = cur[0] + hx[h];
					int ny = cur[1] + hy[h];
					
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					if(v[nx][ny][cur[2]+1] || board[nx][ny] == -1) continue;
					// 이미 방문했거나 벽이면 pass
					v[nx][ny][cur[2]+1] = true;
					// 점프 횟수와 이동 거리를 넣음
					q.offer(new int[] {nx, ny, cur[2]+1, cur[3]+1});
				}
			}

			for(int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				if(v[nx][ny][cur[2]] || board[nx][ny] == -1) continue;
				// 이미 채워졌거나 벽이면 pass
				v[nx][ny][cur[2]] = true;
				// 점프 횟수와 이동 거리를 넣음
				q.offer(new int[] {nx, ny, cur[2], cur[3]+1});
			}
		}
		
		// 갈 수 없음
		return -1;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		v = new boolean[H][W][K+1];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < W; j++) {
				// 1은 -1로 넣기
				board[i][j] = -Integer.parseInt(st.nextToken());
			}
		}
		

		System.out.println(bfs(0, 0));
		
		br.close();
	}
}