import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int [] D = new int[N+1];
			int [] dp = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
				dp[i] = D[i]; // 최대시간 갱신
			}
			int [] cnt = new int[N+1];
//			ArrayList<Integer> [] list = new ArrayList[N+1];
//			for(int i = 1; i<= N; i++) list[i] = new ArrayList<>();
			boolean [][] G = new boolean[N+1][N+1];
			
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				cnt[Y]++; // 필요한 건물의 수
//				list[X].add(Y); // Y건물 짓는데 X 필요
				G[X][Y] = true;
			}
			int W = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for(int i = 1 ; i <= N; i++) {
				if(cnt[i] == 0) {
					
					q.offer(i);
					
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				if(cur==W) continue;
//				for(Integer d : list[cur]) {
//					// 갱신
//					dp[d] = Math.max(dp[d], D[d]+dp[cur]);
//					q.offer(d);
//				}
				
				for(int j = 1; j <= N; j++) {
					if(cur==j) continue;
					if(G[cur][j]) {
						dp[j] = Math.max(dp[j], D[j]+dp[cur]);
						if(--cnt[j]==0) q.offer(j);
					}
				}
			}
			
//			System.out.println("T : "+T);
//			for(int i = 1 ; i <= N; i++) {
//				System.out.println(dp[i]);
//			}
			
			
			sb.append(dp[W]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}