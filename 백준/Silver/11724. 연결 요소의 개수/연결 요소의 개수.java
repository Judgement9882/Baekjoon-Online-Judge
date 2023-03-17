import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<Integer> [] g = new List[N+1];
		for(int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			g[A].add(B); g[B].add(A);
		}
		
		boolean []v = new boolean[N+1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(v[i]) continue;
			cnt++;
			q.offer(i);
			v[i] = true;
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int j : g[cur]) {
					if(v[j]) continue;
					v[j] = true;
					q.offer(j);
				}
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}
