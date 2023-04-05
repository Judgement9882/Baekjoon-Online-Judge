import java.io.*;
import java.util.*;
public class Main {
	static int N, L, ans;
	static int[][] board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc <= T; tc++) {
			/*
			 * 
			 * 	경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
				낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
				경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속되어 있어야 한다.
				아래와 같은 경우에는 경사로를 놓을 수 없다.
				
				
				
				
				
			 */
			
//			sb.append("#"+tc+" ").append(ans==Integer.MAX_VALUE?"GAME OVER":ans).append("\n");
//		}
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		ans = 0;
		board = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
			solve(board[i]);
		}
		
		for(int j = 0; j < N; j++) {
			int [] temp = new int[N];
			for(int i = 0 ; i < N; i++) {
				temp[i] = board[i][j];
			}
			solve(temp);
		}
		
		System.out.println(ans);
		br.close();
	}
	
	static void solve(int[] arr) {
		// 경사로를 놓은 곳에 또 경사로를 놓는 경우 -> 설치 처리
		boolean [] v = new boolean[N];
		int index = 0;
		while(index < N-1) {
			// 낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
			if(Math.abs(arr[index] - arr[index+1]) >= 2) return;
			
			else if(arr[index] == arr[index+1]) {
				index++;
				continue;
			}
			
			// 작아지는 경우
			if(arr[index] > arr[index+1]) {
				// 경사로를 놓다가 범위를 벗어나는 경우
				if(index + L >= N) return;
				
				// index+1 부터 index+L 까지 공간 확보 되어야함
				// 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
				for(int l = 1; l < L; l++) {
					if(arr[index+l] != arr[index+l+1]) { // 다르다면 적합하지 않음
						return;
					}
				}
				
				// 공간 확보 된 상태 - 방문처리(설치)
				for(int l = 1; l <= L; l++) v[index+l] = true;
				index += L;
				
				continue;
			}

			// 커지는 경우
			else if (arr[index] < arr[index+1]) {
				// 경사로를 놓다가 범위를 벗어나는 경우
				if(index - L +1 < 0) return;
				
				// 설치한 경우 제외
				for(int l = 0; l < L; l++) {
					if(v[index-l]) return;
				}
				
				// index 부터 index-L+1 까지 공간 확보 되어야함
				// 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
				for(int l = 0; l < L-1; l++) {
					if(arr[index-l] != arr[index-l-1]) { // 다르다면 적합하지 않음
						return;
					}
				}
				
				// 공간 확보 된 상태 - 방문처리(설치)
				for(int l = index; l >= index-L+1; l--) v[l] = true;
				index++;
				
				continue;
			}
		}
		ans++;
	}
}