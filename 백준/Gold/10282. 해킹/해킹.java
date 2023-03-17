import java.io.*;
import java.util.*;
public class Main {
	static int N, M, start, ans;
	static List<int[]>[] g;
	static int[] dist;
	static PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2)->{
		return Integer.compare(o1[1], o2[1]);
	});
	static final int INF = Integer.MAX_VALUE/2;
	
	static int dijkstra() {
		dist = new int[N+1];
		for(int i = 1; i <= N; i++) dist[i] = INF;
		
		pq.clear();
		dist[start] = 0;
		pq.offer(new int[] {start, 0});
		int ansDist = 0;
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int minVertex = cur[0];
			int min = cur[1];
			
			
			
			// 더 큰 가중치라면 pass
			if(min > dist[minVertex]) continue;
			ans++;
			ansDist = min;
			for(int[] j : g[minVertex]) {
				// 더 작다면 이전 기록 다 날리고 갱신
				if( dist[j[0]] > min + j[1]) {
					dist[j[0]] = min + j[1];
					
					pq.offer(new int[] {j[0], dist[j[0]]});
				}
			}
		}
		return ansDist;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 1
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			

			g = new List[N+1];
			for(int i = 1 ;i <= N; i++) { 
				g[i] = new ArrayList<>();
			}

			// 2
			for(int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int to   = Integer.parseInt(st.nextToken());
				int from     = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				g[from].add(new int[] {to , weight});
			}
			ans = 0; 
			 // 최단 경로들 찾기
			int num= dijkstra();
			sb.append(ans+" "+num+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
