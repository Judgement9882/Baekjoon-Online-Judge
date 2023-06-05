import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static ArrayList<Integer> colorValue;
	static int[][] board, answer;
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 0. 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[N][M];
		board = new int[N][M];
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				answer[i][j] = board[i][j] = temp.charAt(j)-'0';
			}
		}

		// 1. 0을 색칠 -1, -2, -3...
		int color = -1;
		colorValue = new ArrayList<>(); // 각 색깔의 값
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 0) {
					coloring(i, j, color--);
				}
			}
		}
		
		// 2. 1 주변에 어떤 칸이 있는지 set에 넣고 더하기. set이 비어있으면 0
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 1) {
					calc(i, j);
				}
			}
		}
		
		
		// 3. 출력
		print();
		
		System.out.println(sb);
		br.close();
	}
	
	// answer갱신
	static void calc(int x, int y) {
		HashSet<Integer> set = new HashSet<>(); // 주변 색깔 저장
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(checkOut(nx, ny) || board[nx][ny] > 0) continue;
			set.add(board[nx][ny]);
		}
		
		// 주변에 공간 없으면 0
		if(set.size()==0) answer[x][y] = 1;
		else {
			Object[] obj = set.toArray();
			
			int val = 1;
			for(Object o : obj) {
				val += colorValue.get((Math.abs((Integer) o))-1);
			}
			answer[x][y] = val%10;
		}
	}
	
	static void coloring(int x, int y, int color) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		board[x][y] = color;
		int value = 1;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(checkOut(nx, ny) || board[nx][ny] != 0) continue;
				q.offer(new int[] {nx, ny});
				board[nx][ny] = color;
				value++;
			}
		}
		
		// 해당 색깔 값 갱신
		colorValue.add(value);
	}
	
	static boolean checkOut(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}
	
	static void print() {
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(answer[i][j]);
			}
			sb.append("\n");
		}
	}
}