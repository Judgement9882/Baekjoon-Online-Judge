import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int [] p;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
		return Integer.compare(o1[2], o2[2]);
	});
	
	static void makeSet(int cnt) {
		p = new int[cnt+1];
		for(int i = 1; i <= cnt; i++) p[i] = i;
	}
	
	static int findSet(int a) {
		if(a == p[a]) return a;
		return p[a] = findSet(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;  return true;
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		

		
		makeSet(N);
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from   = Integer.parseInt(st.nextToken());
			int to     = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.offer(new int[] {from, to, weight});
		}
		
		// 임의의 두 집 사이에 항상 경로가 존재하므로
		// N이 2, M이 1 일 경우, 그 길을 없애서 도시 분할 가능
		if(M==1) System.out.println(0);
		else {
			int ans = 0;
			int cnt = 0;
			while(!pq.isEmpty()) {
				int cur[] = pq.poll();
				if(union(cur[0], cur[1])) {
					ans += cur[2];
					if(++cnt == N-2) break;
				}
			}
			
			System.out.println(ans);
		}
		br.close();
	}
}