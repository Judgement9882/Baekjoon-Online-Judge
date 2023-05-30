import java.io.*;
import java.util.*;
public class Main {
	static int[][] board, copy;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 열의 개수
		M = Integer.parseInt(st.nextToken()); // 행의 개수
		board = new int[N][M];
		boolean cheese = false;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				// 치즈가 없는 경우 고려
				if(board[i][j] == 1) cheese = true;
//				System.out.println(cheese);
//				System.out.println(i+" " + j);
			}
		}
		
		int ans = 0;
		
		if(cheese) { // 치즈가 있는 경우
			while(true) {	
				// 0. 연산에 사용할 카피보드 만들기
				init();
				// 1. 가장자리에서 bfs 시작하여 외부를 2로 설정
				changeCopyTwo();
				// 2. 전부 탐색하면서 1인 부분 4방 탐색하여 2 개수가 2개 이상이면 원본 배열에서 0으로 바꿈
				// 이 과정에서 1의 개수를 리턴하여 반복여부 체크
				if(changeBoardZero() == 0) break;
				ans++;
			}	
		}
		System.out.println(ans);
	    br.close();
	}
	
	static void init() {
		copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				copy[i][j] = board[i][j];
			}
		}
	}
	
	// 밖으로 나가면 true
	static boolean checkOut(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}
	
	static void changeCopyTwo() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		copy[0][0] = 2;
		q.offer(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(checkOut(nx, ny) || copy[nx][ny] != 0) continue;
				copy[nx][ny] = 2;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	static int changeBoardZero() {
		int ret = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(copy[i][j] == 1) {
					ret++;
					int melt = 0;
					// 4방 탐색
					for(int dir = 0; dir < 4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						// 치즈는 가장자리에는 없어서 범위체크는 안함
						if(copy[nx][ny] == 2) melt++;
					}		
					
					if(melt >= 2) board[i][j] = 0;
				}
			}
		}
		return ret;
	}
}