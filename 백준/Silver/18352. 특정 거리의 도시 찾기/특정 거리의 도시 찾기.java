import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N, M, K, X;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		List<Integer> [] g = new List[N+1];
		for(int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			g[A].add(B);
		}
		
		boolean []v = new boolean[N+1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(X);
		ArrayList<Integer> answer = new ArrayList<>();
		int depth = 0, ans = -1;
		v[X] = true;
		while(!q.isEmpty()) {
			if(depth++ == K) {
				ans = 0;
				while(!q.isEmpty()) {
					answer.add(q.poll());
				}
			}
			
			int qSize = q.size();
			while(qSize -- > 0) {
				int cur = q.poll();
				for(int i : g[cur]) {
					if(v[i]) continue;
					v[i] = true;
					q.offer(i);
				}
			}
		}
		
		if(ans==-1) System.out.println(ans);
		else {
			Collections.sort(answer);
			for(int i : answer) sb.append(i+"\n");
			
			System.out.println(sb);
		}
		br.close();
	}
}
