import java.io.*;
import java.util.*;

public class Main{
	static int N, M, min_chick;
	static int[][] board;
	static int[] selectedChicken;
	static List<int[]> home, chicken;
	
	static void comb(int cnt, int start) {
		if(cnt == M) {
			int sum = 0;
			for(int[] xy : home) {
				int x = xy[0];
				int y = xy[1];
				
				int dis = Integer.MAX_VALUE / 2;
				for(int i = 0; i < M; i++) {
					int cx = chicken.get(selectedChicken[i])[0];
					int cy = chicken.get(selectedChicken[i])[1];
					dis = Math.min(Math.abs(cx - x) + Math.abs(cy - y), dis);
					
				}
				sum += dis;
			}
			min_chick = Math.min(sum, min_chick);
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			selectedChicken[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		min_chick = Integer.MAX_VALUE / 2;
		board = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) home.add(new int[] {i, j});
				else if(board[i][j] == 2) chicken.add(new int[] {i, j});
			}
		}
		
		selectedChicken = new int[M];
		comb(0, 0);
		System.out.println(min_chick);
		br.close();
	}
}
