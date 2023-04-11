import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int [][] g;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		g = new int[N+1][N+1];
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			g[c][d] = 1;
			g[d][c] = 1;
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean [] v = new boolean[N+1];
		q.offer(new int[] {a, 0});
		v[a] = true;
		int ans = -1;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int i = 1; i <= N; i++) {
				if(v[i] || g[cur[0]][i] == 0) continue;
				if(g[cur[0]][b] == 1) {
					ans = cur[1]+1;
					while(!q.isEmpty())q.poll();
					break;
				}
				v[i] = true;
				q.offer(new int[] {i, cur[1]+1});
			}
		}
		System.out.println(ans);
		br.close();
	}
}