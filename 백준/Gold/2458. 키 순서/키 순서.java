import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static final int INF = Integer.MAX_VALUE/2;
	static int [][] g;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new int[N+1][N+1];
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1 ; j <= N; j++) {
				if(i!=j) g[i][j] = INF;
			}
		}
		
		for(int i = 0 ; i < M; i++) {
			st =new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from][to] = 1;
		}
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(i==k) continue;
				for(int j = 1 ; j <= N; j++) {
					if(k==j || i==j) continue;
					g[i][j] = Math.min(g[i][k]+g[k][j], g[i][j]);
				}
			}
		}
		
		int [] ans = new int[N+1];
		int cnt = 0;
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(k==i) continue;
				if(g[k][i] != INF) ans[k]++;
				if(g[i][k] != INF) ans[k]++;
			}
			if(ans[k] == N-1) cnt++;
		}
		System.out.println(cnt);
		br.close();
	}
}