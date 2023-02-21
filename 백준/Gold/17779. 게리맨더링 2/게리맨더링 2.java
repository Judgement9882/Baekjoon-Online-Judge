import java.io.*;
import java.util.*;
public class Main{
	
	static int N, totalPick, ans;
	static int [][] board;
	static int [][] gery;
	
	static void divide(int x, int y, int d1, int d2) {
		gery = new int[N+1][N+1];
		int max_pick = Integer.MIN_VALUE;
		int min_pick = Integer.MAX_VALUE;
		
		// 5 구역 만들기
        for (int m = 0; m <= d1; m++) {
            gery[x + m][y - m] = 5;
            gery[x + d2 + m][y + d2 - m] = 5;
        }

        for (int m = 0; m <= d2; m++) {
            gery[x + m][y + m] = 5;
            gery[x + d1 + m][y - d1 + m] = 5;
        }
        
        // 나머지 구역 구하기
        // 1
        int temp5 = totalPick;
        
        int temp = 0;
        for(int i = 1; i < x+d1; i++) {
        	for(int j = 1; j <= y; j++) {
        		// 경계값이면 패스
        		if(gery[i][j] == 5) break;
        		temp += board[i][j];
        	}
        }
        max_pick = Math.max(max_pick, temp);
        min_pick = Math.min(min_pick, temp);
        temp5 -= temp;
        // 2
        temp = 0;
        for(int i = 1; i <= x+d2; i++) {
        	for(int j = N; j > y; j--) {
        		// 경계값이면 패스
        		if(gery[i][j] == 5) break;
        		temp += board[i][j];
        	}
        }
        max_pick = Math.max(max_pick, temp);
        min_pick = Math.min(min_pick, temp);
        temp5 -= temp;
        // 3
        temp = 0;
        for(int i = x+d1; i <= N; i++) {
        	for(int j = 1; j < y-d1+d2; j++) {
        		// 경계값이면 패스
        		if(gery[i][j] == 5) break;
        		temp += board[i][j];
        	}
        }
        max_pick = Math.max(max_pick, temp);
        min_pick = Math.min(min_pick, temp);
        temp5 -= temp;
        // 4
        temp = 0;
        for(int i = x+d2+1; i <= N; i++) {
        	for(int j = N; j >= y-d1+d2; j--) {
        		// 경계값이면 패스
        		if(gery[i][j] == 5) break;
        		temp += board[i][j];
        	}
        }
        max_pick = Math.max(max_pick, temp);
        min_pick = Math.min(min_pick, temp);
        temp5 -= temp;
        
        max_pick = Math.max(max_pick, temp5);
        min_pick = Math.min(min_pick, temp5);
        
        ans = Math.min(ans, max_pick - min_pick);
	}
	
	static void pickPos(int d1, int d2) {
		for(int x = 1; x + d1 + d2 <= N; x++) {
			for(int y = 1 + d1; y + d2 <= N; y++) {
				divide(x, y, d1, d2);
			}
		}
	}
	
	// d1, d2 의 값을 정하는 함수. 
	// N이 되면 종료 (d1+d2 <= N-1)
	static void func(int cnt) {
		if(cnt == N) {
			return;
		}
		
		for(int i = 1; i < cnt; i++) {
			pickPos(i, cnt-i);
		}
		func(cnt+1);
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		totalPick = 0;
		ans = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine(),  " ");
			for(int j= 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				totalPick += board[i][j];
			}
		}
		
		func(2);
		System.out.println(ans);
		br.close();
	}
}
