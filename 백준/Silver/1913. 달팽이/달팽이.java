import java.io.*;
import java.util.*;
public class Main {
	static int[][] board;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static int N, F;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		F = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		int num = 1, dist = 1;
		int x = N/2, y = N/2;
		board[x][y] = 1;
		end : while(true) {
			for(int d = 0; d < 2; d++) {
				for(int rep = 0; rep < dist; rep++) {
					x += dx[d];
					y += dy[d];
					board[x][y] = ++num;
					if(num == N*N) {
						break end;
					}
				}
			}
			dist++;
			for(int d = 2; d < 4; d++) {
				for(int rep = 0; rep < dist; rep++) {
					x += dx[d];
					y += dy[d];
					board[x][y] = ++num;
				}
			}
			dist++;
		}
		int a=0, b=0;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				sb.append(board[i][j]+ " ");
				if(board[i][j] == F) {
					a = i+1;
					b = j+1;
				}
			}
			sb.append("\n");
		}
		sb.append(a + " " + b);
		System.out.println(sb);
		br.close();
	}
}