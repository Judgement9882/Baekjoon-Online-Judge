import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N, E, K;
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		final int INF = Integer.MAX_VALUE/2;
		List<int[]>[] g = new ArrayList[N+1];
		boolean [] v = new boolean[N+1];
		int [] dist = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			g[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
			Integer.compare(o1[1], o2[1])
		);
		
		st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= E ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, weight});
		}
		
		dist[K] = 0; int cnt = 0;
		pq.offer(new int[] {K, 0});
		while(!pq.isEmpty()) {
			int current[] = pq.poll();
			int minVertex = current[0];
			int min = current[1];
			// 방문한 정점이면 다시 continue
			if(v[minVertex]) continue;
			v[minVertex] = true;
			if(cnt++ == N-1) break;
			// 마지막 정점이 N에 도달하면 종료
//			if(minVertex == N) break; 
			for(int [] cur : g[minVertex]) {
				if(v[cur[0]]) continue;
				if(dist[cur[0]] > min + cur[1]) {
					dist[cur[0]] = min + cur[1];
					pq.offer(new int[] {cur[0], dist[cur[0]]});
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(dist[i] == INF?"INF\n":dist[i]+"\n");
		}
		System.out.println(sb);
	}
}