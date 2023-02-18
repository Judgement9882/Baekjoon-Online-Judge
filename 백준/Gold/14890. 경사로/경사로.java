import java.io.*;
import java.util.*;
public class Main{
	
	static int N, L, ans;
	static int[][] board;
	
	static boolean check(int x, int y, boolean column) {
		int[] arr = new int[N]; // 사용할 행 or 열을 1차원 배열로 선언
        boolean[] isused = new boolean[N]; // 경사로 사용여부 저장
        for (int i = 0; i < N; i++) {
            if (!column) { // 행일경우
                arr[i] = board[x][i];
            } else { // 열일경우
                arr[i] = board[i][y];
            }
        }
 
        for (int i = 0; i < N-1; i++) { 
        	// 같을경우 pass
            if (arr[i] == arr[i + 1]) continue;
            
            // 높이가 2 이상 차이날떄
            if (Math.abs(arr[i] - arr[i + 1]) > 1) return false; 
            
            // 내려가는 경우
            if (arr[i] - 1 == arr[i + 1]) { 
            	// 다음 수부터 L번째까지 확인
                for (int j = i + 1; j <= i + L; j++) {
                	// 만약 범위를 벗어나거나, 경사로로 썼거나, 값이 달라지는 경우
                    if (j >= N || arr[i + 1] != arr[j]) return false;
                    
                    // 조건 만족 시 경사로 사용
                    isused[j] = true;
                } 
            }
            // 올라가는 경우
            else { 
            	// 이전수를 확인
            	for (int j = i; j >= i-L+1; j--) {
            		// 범위를 벗어나거나, 경사로로 썼거나, 값이 달라지는 경우
            		if(j <0 || isused[j] || arr[i] != arr[j]) return false;
            		
            		// 경사로 사용
            		isused[j] = true;
            	}
            }
        }
        return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		ans = 0;
		
		board = new int [N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j= 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i< N; i++) {
			if(check(i, 0, false)) ans++;
			if(check(0, i, true)) ans++;
		}
		
		System.out.println(ans);
		br.close();
	}
}
