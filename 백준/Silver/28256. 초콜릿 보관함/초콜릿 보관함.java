import java.io.*;
import java.util.*;
public class Main {
	static int []  dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			// 3x3 입력받기
			char [][] board = new char[3][3];
			for(int i = 0 ;i < 3; i++) {
				String temp = br.readLine();
				for(int j = 0; j <3; j++) {
					board[i][j] = temp.charAt(j);
				}
			}
			
			boolean[][]v = new boolean[3][3];
			ArrayList<Integer> near = new ArrayList<>(); // 인접한 칸 개수 저장
			ArrayDeque<int[]> q = new ArrayDeque<>();
			for(int i = 0 ;i < 3; i++) {
				for(int j = 0; j <3; j++) {
					if(v[i][j] == false && board[i][j] == 'O') {
						q.offer(new int[] {i,j});
						v[i][j] = true;
						int num = 1;
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							for(int dir = 0; dir < 4; dir++) {
								int nx = dx[dir]+ cur[0];
								int ny = dy[dir]+ cur[1];
								if(checkOut(nx, ny) || v[nx][ny]) continue;
								if(board[nx][ny] != 'O') continue;
								
								q.offer(new int[] {nx, ny});
								v[nx][ny] = true;
								num++;
							}
						}
						
						// 개수 추가
						near.add(num);
					}
				}
			}
			
			// 개수 정렬
			Collections.sort(near);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			boolean flag = false; // 0
			if(n==near.size()) {
				flag = true;
				for(int i = 0 ; i < n; i++) {
					int a = Integer.parseInt(st.nextToken());
					if(near.get(i) != a) {
						flag = false;
						break;
					}
				}
			}
			if(flag) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static boolean checkOut(int x, int y) {
		return x < 0 || x >= 3 || y < 0 || y >= 3;
	}
}