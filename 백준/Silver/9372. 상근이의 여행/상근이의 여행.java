import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			List<Integer>[] g = new List[N+1];
			for(int i = 1; i <= N; i++)g[i] = new ArrayList<>();
			for(int i=0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to   = Integer.parseInt(st.nextToken());
				g[from].add(to);
				g[to].add(from);
			}
			
			int ans = 0;
			boolean[] v = new boolean[N+1];
			for(int i = 1; i <= N; i++) {
				ArrayDeque<Integer> q = new ArrayDeque<>();
				if(v[i]) continue; // 방문했다면 continue
				q.push(i); v[i] = true;
				while(!q.isEmpty()) {
					int cur = q.poll();
					for(int j : g[cur]) {
						if(v[j]) continue;
						q.push(j); v[j] = true; ans++;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}