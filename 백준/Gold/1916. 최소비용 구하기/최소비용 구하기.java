import java.io.*;
import java.util.*;

// 다익스트라
// 가중치에 0가 있다는 것 생각
// 버스 여러개 경로가 들어올 수 있다는 것 유의

public class Main {
	static int N, M;
	static int[][] g;
	static int[] dist;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());

		g = new int[N+1][N+1];
		for(int i = 0; i<= N; i++) {
			for(int j = 0; j <= N; j++) {
				g[i][j] = -1;
			}
		}
		
		dist = new int[N+1];
		v = new boolean[N+1];
		for(int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
		
		for(int i = 1 ; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from	= Integer.parseInt(st.nextToken());
			int to 		= Integer.parseInt(st.nextToken());
			int weight 	= Integer.parseInt(st.nextToken());
			
			if(g[from][to] == -1) g[from][to] = weight; 
			else g[from][to] = Math.min(g[from][to], weight);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist[start] = 0;
		
		for(int i = 1; i <= N; i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j = 1; j <= N; j++) {
				if(!v[j] && min > dist[j]) {
					min = dist[j];
					minVertex = j;
				}
			}
			
			v[minVertex] = true;
			if(minVertex == end) break;
			for(int j = 1; j <= N; j++) {
				if(v[j] || g[minVertex][j] == -1) continue;
				if(dist[j] > min + g[minVertex][j]) {
					dist[j] = min + g[minVertex][j];
					
				}
			}
		}
		System.out.println(dist[end]);
		
		br.close();
	}
}