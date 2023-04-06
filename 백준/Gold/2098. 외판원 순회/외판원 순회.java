import java.io.*;
import java.util.*;
public class Main {
	static int N, ans;
	static int[][] W, dp;
	static final int INF = Integer.MAX_VALUE/100;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[1<<N][N]; // x도시 누적 방문 , 시작 도시
		for(int i = 0 ; i < 1<<N; i++) {
			for(int j = 0; j < N; j++) {
				dp[i][j] = -1; // 최솟값 초기화
			}
		}
		ans = tsp(1, 0); // 
		System.out.println(ans);
		br.close();
	}
	
	static int tsp(int visited, int city) {
		// 기저조건
		if(visited == ((1<<N) -1)) { // 모든 도시를 다 돌았다면
			if(W[city][0] == 0) return INF; // 마지막 도시 -> 시작점 연결 안된다면
			return W[city][0]; // 마지막 도시 - 처음 도시 거리
		}
		
		// -1이 아니라면 이미 방문한 경로이므로 바로 리턴(메모이제이션)
		if(dp[visited][city]!= -1) {
			return dp[visited][city];
		}
		
		dp[visited][city] = INF; // 방문
		for(int i = 0; i < N; i++) {
			// 이미 방문했다면 continue
			if((visited & (1<<i)) != 0) continue;
			
			// 도시 연결안됨
			if(W[city][i] == 0) continue;
			
			
			// visited, city 갱신
			int res = tsp(visited | (1<<i), i) + W[city][i];
			dp[visited][city] = Math.min(res,  dp[visited][city]);
		}
		return dp[visited][city];
	}
}