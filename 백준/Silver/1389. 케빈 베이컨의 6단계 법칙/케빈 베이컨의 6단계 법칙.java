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
			g[A][B] = g[B][A] = 1;
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
		
		int ans = INF, ansPerson = 0;
		for(int i = 1; i<= N; i++) {
			int cnt = 0;
			for(int j = 1; j <= N; j++) {
				if(i==j) continue;
				cnt += g[i][j];
			}
			if( ans > cnt) {
				ans = cnt;
				ansPerson = i;
			}
		}
		System.out.println(ansPerson);
		br.close();
	}
}