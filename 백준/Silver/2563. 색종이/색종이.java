import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int [][] board = new int[101][101];
		
		for(int T = 0; T < N; T++) {
			st = new StringTokenizer(br.readLine(), " ");			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			for(int x = i; x < i+10; x++) {
				for(int y = j ; y < j + 10; y++) {
					board[x][y] = 1;
				}
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				sum += board[i][j];
			}
		}
		
		System.out.println(sum);
		
		br.close();
	}
}
