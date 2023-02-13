import java.io.*;
import java.util.*;

public class Main{
	static int N, generation; // 첫째 줄에 드래곤 커브의 개수 N(1 ≤ N ≤ 20)이 주어진다.
	static final int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
	static boolean[][] board = new boolean[101][101];
	static ArrayDeque<Integer> s = new ArrayDeque<>();
	static ArrayDeque<Integer> dq = new ArrayDeque<>();
	
	// 드래곤 커브 진행
	static void curv(int x, int y, int g) {
		board[y][x] = true;
		int dir = s.poll();
		x += dx[dir];
		y += dy[dir];		
		board[y][x] = true;
		g++;
		s.push((dir+1)%4);
//		System.out.println("x : " + x + " " + " y :" + y + "\n");
		while(true) {

			if(g++ == generation+1) break;
			
			while(!s.isEmpty()) {
				dir = s.poll();
				x += dx[dir];
				y += dy[dir];
				
				board[y][x] = true;
				dq.offerFirst(dir);
				dq.offerLast((dir+1)%4);
//				System.out.println("x : " + x + " " + " y :" + y + "\n");
			}
			while(!dq.isEmpty()) {
				s.push(dq.poll());
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 드래곤 커브 개수
		
		// 둘째 줄부터 N개의 줄에는 드래곤 커브의 정보가 주어진다.
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 드래곤 커브의 정보는 네 정수 x, y, d, g로 이루어져 있다.
			// x와 y는 드래곤 커브의 시작 점, d는 시작 방향, g는 세대이다. 
			// (0 ≤ x, y ≤ 100, 0 ≤ d ≤ 3, 0 ≤ g ≤ 10)
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			s.push(d);
			generation = Integer.parseInt(st.nextToken());
			curv(x, y, 0);
			while(!s.isEmpty())s.pop();
		}
		
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0 ; j < 100; j++) {
				if(board[i][j] && board[i+1][j] && board[i][j+1] && board[i+1][j+1])
					cnt++;
				
//				System.out.print(board[i][j]?"1 ":"0 ");
			}
//			System.out.println();
		}
		System.out.println(cnt);
	}
}
