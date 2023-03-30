import java.io.*;
import java.util.*;
public class Main {
	static int [][] board = new int[9][9];
	static int [] garo, sero, square;
	static final int num = (1<<10) -1;
	
	static void printBoard() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	static void dfs(int cnt) {
		if(cnt==81) {
			printBoard();
			System.exit(0);
		}
		int x = cnt / 9;
		int y = cnt % 9;
		int xy = calc(x, y);
		if(board[x][y] == 0) {
			for(int n = 1; n < 10; n++) {
				if( ((garo[x] & (1<<n)) == 0) && ((sero[y] & (1<<n)) == 0) && ((square[calc(x, y)] & (1<<n)) == 0)) {
//				if(!garo[x][n] && !sero[y][n] && !square[calc(x, y)][n]) {
					board[x][y] = n;
					garo[x] |= (1<<n);
					sero[y] |= (1<<n);
					square[calc(x, y)] |= (1<<n);
					dfs(cnt+1);
					board[x][y] = 0;
					garo[x] &= (num ^ (1<<n));
					sero[y] &= (num ^ (1<<n));
					square[calc(x, y)] &= (num ^ (1<<n));
				}
			}	
		}
		else {
			dfs(cnt+1);
		}
	}
	
	static int calc(int x, int y) {
		if(x <= 2) {
			if(y <= 2) 		return 0;
			else if (y<=5) 	return 3;
			else 			return 6;
		}else if (x <= 5) {
			if(y <= 2) 		return 1;
			else if (y<=5) 	return 4;
			else 			return 7;			
		}else {
			if(y <= 2) 		return 2;
			else if (y<=5) 	return 5;
			else 			return 8;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		garo = new int[9];
		sero = new int[9];
		square = new int[9];
		for(int i = 0; i < 9; i++) {
			String temp = br.readLine();
			for(int j = 0; j < 9; j++) {
				board[i][j] = temp.charAt(j) - '0';
				if(board[i][j] != 0) {
					garo[i] |= (1<<board[i][j]);
					sero[j] |= (1<<board[i][j]);
					square[calc(i, j)] |= (1<<board[i][j]);	
				}
			}
		}
		dfs(0);
		br.close();
	}
}