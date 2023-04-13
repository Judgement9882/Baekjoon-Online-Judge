import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		final int INF = Integer.MAX_VALUE/2;
		int [][] g = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i==j) continue;
				g[i][j] = INF;
			}
		}
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			g[A][B] = C;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(k==i) continue;
				for(int j = 1; j <= N; j++) {
					if(k==j || i == j) continue;
					
					g[i][j] = Math.min(g[i][j], g[i][k]+g[k][j]);
				}
			}
		}
		
		int ans = INF;
		for(int i = 1; i<= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i==j) continue;
				if(g[j][i] != INF) { // 사이클이 생기는 경우
					ans = Math.min(ans, g[i][j] + g[j][i]);
				}
			}
		}
		System.out.println(ans==INF?-1:ans);
		br.close();
	}
}