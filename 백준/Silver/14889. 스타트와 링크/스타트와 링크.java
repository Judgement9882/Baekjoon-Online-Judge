import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // should change Main

	static int N;
	static int ans = Integer.MAX_VALUE;
	static int [][] board;
	static int []isused;
	
	static void func(int start, int k) {
		
		// 팀이 선정된 경우
		if (k == N/2) {
			int A_score = 0;
			int B_score = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = i; j < N ; j++) {
					if(isused[i] == 0) {
						if(isused[j] == 0) {
							A_score += board[i][j] + board[j][i];
						}
					}
					
					else {
						if(isused[j] == 1) {
							B_score += board[i][j] + board[j][i];
						}
					}
				}
			}
			
			ans = Math.min(ans, Math.abs(A_score-B_score));
			return;
		}
		
		
		for(int i = start ; i < N-1; i++) {
			// 아직 사용하지 않았다면
			if(isused[i] == 0) {
				isused[i] = 1;
				func(i+1, k+1);
				isused[i] = 0;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 입력
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		isused = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 백트래킹 시작
		func(0, 0);
		
		System.out.println(ans);
	}
}
