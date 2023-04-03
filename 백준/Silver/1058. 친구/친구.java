import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		final int INF = Integer.MAX_VALUE/2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] board = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < temp.length(); j++) {
				board[i][j] = temp.charAt(j)=='N'?0:1;
				if(board[i][j] == 0 && i!=j) board[i][j] =INF; 
			}
		}
		for(int k = 0 ; k < N; k++) {
			for(int i = 0; i < N; i++) {
				if(i==k) continue;
				for(int j = 0; j < N; j++) {
					if(k==j || j == i) continue;
					board[i][j] = Math.min(board[i][j], board[i][k]+board[k][j]);
				}
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < N; i++) {
			int cnt = 0;
			for(int j = 0 ; j < N; j++) {
				if(i==j) continue;
				if(board[i][j] <= 2) cnt++;
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
		br.close();
	}
}