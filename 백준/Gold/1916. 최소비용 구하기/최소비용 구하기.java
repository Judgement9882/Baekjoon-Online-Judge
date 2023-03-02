import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		int[][] g = new int[N+1][N+1];
		for(int[] i : g) Arrays.fill(i, -1);
		StringTokenizer st;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(g[from][to] != -1) g[from][to] = Math.min(g[from][to], cost);
			else g[from][to] = cost;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		boolean[] v = new boolean[N+1];
		long[] dis = new long[N+1];
		for(int i=1; i<=N; i++) dis[i] = Long.MAX_VALUE;
		
		dis[start] = 0;
		for(int i=1; i<=N; i++) {
			long min = Long.MAX_VALUE;
			int minVertex = -1;
			
			for(int j=1; j<=N; j++) {
				if(!v[j] && min > dis[j]) {
					min = dis[j];
					minVertex = j;
				}
			}
			
			v[minVertex] = true;
			if(minVertex==end) break;
			for(int j=1; j<=N; j++) {
				if(!v[j] && g[minVertex][j]!=-1 && dis[j] > min + g[minVertex][j]) {
					dis[j] = min + g[minVertex][j];
				}
			}
		}
		System.out.println(dis[end]);
		br.close();
	}
}
