import java.io.*;
import java.util.*;
public class Main {
	// 우, 하, 좌, 상
	static int N;
	static int [] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static int[][] board;
	static HashMap<Integer, Character> orderMap = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		board = new int[N][N];
		while(K-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			// 사과는 -1
			board[x][y] = -1; 
		}
		
		int L = Integer.parseInt(br.readLine());
		while(L-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			orderMap.put(X, C);
		}
		
		// 뱀 시작 위치
		board[0][0] = 1;
		// 뱀의 위치정보를 담는 deque
		ArrayDeque<int[]> deq = new ArrayDeque<>();
		deq.offer(new int[] {0, 0});
		
		int X = 0;
		// 초기 방향은 오른쪽
		int dir = 0;
		while(++X <= 10000) {
			// 몸 길이 늘려 
			int head[] = deq.peekLast(); 
			int nx = head[0] + dx[dir];
			int ny = head[1] + dy[dir];
			
			// 벽이나 자기자신의 몸과 부딪히면 게임 끝
			if(isCrashed(nx, ny) || board[nx][ny] == 1) break;
			
			// 사과가 없다면
			if(board[nx][ny] != -1) {
				// 꼬리가 위치한 칸을 비워줌
				int tail[] = deq.poll();
				board[tail[0]][tail[1]] = 0;
			}
			
			// 다음칸에 머리 위치
			board[nx][ny] = 1;
			deq.offer(new int[] {nx, ny});
			
//			// debug
//			System.out.println("Debug" + X);
//			for(int i = 0; i < N; i++) {
//				for(int j = 0 ; j < N; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			// 방향전환 체크
			if(orderMap.containsKey(X)) dir = changeDir(dir, orderMap.get(X));
		}
		System.out.println(X);
		br.close();
	}
	
	// 방향을 바꾸는 함수
	static int changeDir(int dir, char C) {
		if (C=='L') dir+=3;
		else if (C=='D') dir++;
		return dir%4;
	}
	
	// 벽에 부딪히면 true
	static boolean isCrashed(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}