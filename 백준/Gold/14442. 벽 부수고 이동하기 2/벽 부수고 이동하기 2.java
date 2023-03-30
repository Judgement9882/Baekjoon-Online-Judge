import java.io.*;
import java.util.*;
public class Main {
	
	static int[][] board;
	static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
	static int K, W, H;
	static boolean[][] v;
	
	static int bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		v[0][0] = true;
		// x, y, k, dist
		q.offer(new int[] {x, y, 0, 1});
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			if(cur[0] == H-1 && cur[1] == W-1) return cur[3];

			for(int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				if(cur[2] < K && board[nx][ny] == -1 && !v[nx*W+ny][cur[2]+1]) {
					v[nx*W+ny][cur[2]+1] = true;
					q.offer(new int[] {nx, ny, cur[2]+1, cur[3]+1});
				}
				if(v[nx*W+ny][cur[2]] || board[nx][ny] == -1) continue;
				v[nx*W+ny][cur[2]] = true;
				q.offer(new int[] {nx, ny, cur[2], cur[3]+1});
			}
		}
		
		// 갈 수 없음
		return -1;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		K = Integer.parseInt(br.readLine());
//		K = 1;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		v = new boolean[H*W][K+1];
		for(int i = 0; i < H; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
			String temp = br.readLine();
			for(int j = 0; j < W; j++) {
				// 1은 -1로 넣기
				board[i][j] = -(temp.charAt(j)-'0');
			}
		}
		

		System.out.println(bfs(0, 0));
		
		br.close();
	}
}