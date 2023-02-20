import java.io.*;
import java.util.*;

public class Main{
	static int[][] board;
	static StringBuilder sb = new StringBuilder();
	static void cut(int r, int c, int size) {
		int sum = 0;
		for(int i = r, rEnd = r+size; i < rEnd; i++) {
			for(int j = c, cEnd = c+size; j < cEnd; j++) {
				sum += board[i][j];
			}
		}
		
		if(sum == size*size) {
			sb.append("1");
		}else if (sum == 0) {
			sb.append("0");
		}else { 
			// 4분할
			sb.append("(");
			cut(r, c, size/2);
			cut(r, c+size/2, size/2);
			cut(r+size/2, c, size/2);
			cut(r+size/2, c+size/2, size/2);
			sb.append(")");
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] =  temp.charAt(j) - '0';
			}
		}
		
		cut(0, 0, n);
		System.out.println(sb);
		br.close();
	}
}
