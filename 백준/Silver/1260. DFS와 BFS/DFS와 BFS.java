import java.util.*;
import java.io.*;

public class Main{
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static int [][] g;
	static boolean [] v;
	
	static void dfs(int i) {
		sb.append(i+1).append(" ");
		v[i] = true;
		for(int j = 0 ; j < N; j++) {
			if(g[i][j] != 0 && !v[j])
				dfs(j);
		}
	}
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		sb.append(i+1).append(" ");
		v[i] = true;
		q.offer(i);
		
		while(!q.isEmpty()) {
			i = q.poll();
			for(int j = 0 ; j < N; j++) {
				if(g[i][j] != 0 && !v[j]) {
					sb.append(j+1).append(" ");
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 첫째줄 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		
		g = new int[N][N];
		
		// M개의 간선 개수 입력
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to   = Integer.parseInt(st.nextToken())-1;
			
			g[from][to] = 1;
			g[to][from] = 1;
		}
		
//		for(int[] a : g) System.out.println(Arrays.toString(a));
		
		v = new boolean[N];
		dfs(V-1);
		sb.append("\n");
		v = new boolean[N];
		bfs(V-1);
		System.out.println(sb);
		br.close();
	}
}
