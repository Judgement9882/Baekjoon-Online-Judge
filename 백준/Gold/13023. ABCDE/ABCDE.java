import java.io.*;
import java.util.*;

public class Main{
	
	static int N, M;
	static List<Integer>[] g;
	static boolean[] v;
	
	static boolean dfs(int i, int sum) {
		if(sum >= 5 ) return true;
		
		v[i] = true;
		for(int j : g[i]) {
			if(v[j]) continue;
			if(dfs(j, sum+1)) return true;
		}
		v[i] = false;
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new List[N];
		for(int i = 0 ; i < N; i++) g[i] = new ArrayList<>();
				
		for(int i = 0 ;i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			
			g[from].add(to);
			g[to].add(from);
		}
		
		boolean success = false;
		for(int i = 0; i < N; i++) {
			v = new boolean[N];
			if(dfs(i, 1)) {
				success = true;
				break;
			}
		}
		if(success) System.out.println(1);
		else System.out.println(0);
		br.close();
	}
}
