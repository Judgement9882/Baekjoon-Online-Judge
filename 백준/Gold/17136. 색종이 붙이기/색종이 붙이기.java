import java.io.*;
import java.util.*;
public class Main {
	static int [][]board = new int[10][10];
	static int ans;
	static int [] num = {5, 5, 5, 5, 5}; // 5, 4, 3, 2, 1
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i= 0; i < 10; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
//		for(int a : num) System.out.println(a + " ");
		br.close();
	}
	
	static void dfs(int xy, int cnt) {
		if(ans < cnt) return;
		if(xy==100) {
			// 마지막 점까지 해결 완료
			ans = Math.min(ans, cnt);
			return;
		}
		
		for(int ij = xy ;ij <= 100; ij++) {
			if(ij == 100) {
				if(totalCheck()) ans = Math.min(ans, cnt);
				return;	
			}
			int i = ij/10;
			int j = ij%10;			
			if(board[i][j] == 1) {
				for(int d = 5; d > 0; d--) {
					if(num[5-d] > 0 && check(i, j, d)) {
						num[5-d]--;
						update(i, j, d, 0);
						dfs(ij+1, cnt+1);
						num[5-d]++;
						update(i, j, d, 1);
					}
				}
				return;
			}
		}
	}
	
	static boolean check(int x, int y, int d) {
		for(int i = x; i < x+d; i++) {
			for(int j = y; j < y+d; j++) {
				if(i >= 10 || j >= 10 || board[i][j] == 0 ) return false;
			}
		}
		return true;
	}
	
	static void update(int x, int y, int d, int color) {
		for(int i = x; i < x+d; i++) {
			for(int j = y; j < y+d; j++) {
				board[i][j] = color;
			}
		}
	}
	
	static boolean totalCheck() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(board[i][j] == 1) return false;
			}
		}
		return true;
	}
}