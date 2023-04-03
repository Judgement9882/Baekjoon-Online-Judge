import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] board = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < temp.length(); j++) {
				board[i][j] = temp.charAt(j)=='N'?0:1;
			}
		}
		HashSet<Integer>[] set = new HashSet[N];
		for(int i = 0 ; i < N; i++)set[i] = new HashSet<>();
		
		if(N==2) {
			if(board[0][1]==1 && board[1][0] == 1) {
				System.out.println(1);
			}else System.out.println(0);
		}
		else {
			for(int k = 0 ; k < N; k++) {
				for(int i = 0; i < N; i++) {
					if(i==k) continue;
					for(int j = 0; j < N; j++) {
						if(k==j || j == i) continue;
						if((board[i][k] == 1 && board[k][j] == 1) || board[i][j] == 1) {
							set[i].add(j);
						}
					}
				}
			}
			
			int max = 0;
			for(int i = 0 ; i < N; i++) {
				max = Math.max(set[i].size(), max);
			}
			System.out.println(max);
		}
		br.close();
	}
}