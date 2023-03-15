import java.io.*;
import java.util.*;
public class Main {
	
	static int N, M, R, ans;
	static List<int[]> [] g;
	static int[] item;
	static final int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		item = new int[N+1];
		g = new List[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			g[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from   = Integer.parseInt(st.nextToken());
			int to     = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, weight});
			g[to].add(new int[] {from, weight});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->{
			return Integer.compare(o1[1], o2[1]);
		});
		ans = 0;
		// start를 모든 지점에서 확인해봐야함
		for(int start = 1; start <= N; start++) {
			pq.clear();
			int[] dist = new int[N+1];
			for(int i = 1; i <= N; i++) dist[i] = INF;
			boolean[] v = new boolean[N+1];
			
			dist[start] = 0;
			pq.offer(new int[] {start, 0});
			int cnt = 0;
			while(!pq.isEmpty()) {
				int cur[] = pq.poll();
				int minVertex = cur[0];
				int min = cur[1];
				if(v[minVertex]) continue;
				v[minVertex] = true;
//				System.out.println(start + " " + minVertex);
				// 수색범위를 넘어섰다면 break
				if(min > M) break;
				cnt += item[minVertex];
				
				for(int[] j : g[minVertex]) {
//					System.out.println(start + " " + v[j[0]] + " " + dist[j[0]]);
					if(v[j[0]]) continue; // 방문했다면
					if( dist[j[0]] > min + j[1]) {
						dist[j[0]] = min + j[1];
						pq.offer(new int[] {j[0], dist[j[0]]});
					}
				}
			}
			ans = Math.max(ans,  cnt);
		}
		
		System.out.println(ans);
		br.close();
	}
}