import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		final int INF = Integer.MAX_VALUE/2;
		int [][] g = new int[N][N];
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
				if(g[i][j] == 0) {
					if(i==j) g[i][j] = INF;
					else g[i][j] = INF;
				}
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
//				if(i==k) continue;
				for(int j = 0; j < N; j++) {
//					if(j==k || j==i) continue;
					g[i][j] = Math.min(g[i][k]+g[k][j], g[i][j]);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
//				System.out.print(g[i][j]>0?1:0 + " ");
//				sb.append(g[i][j]>0?1:0).append(" ");
				if(g[i][j] == INF || g[i][j] <= 0)
					sb.append(0).append(" ");
				else
					sb.append(1).append(" ");
			}
//			System.out.println();
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}