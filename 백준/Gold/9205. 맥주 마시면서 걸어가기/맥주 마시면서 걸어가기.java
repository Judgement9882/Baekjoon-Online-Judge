import java.io.*;
import java.util.*;


public class Main {
	
	static int N;
	static List<int[]> cpos;
	static int hy, hx, fy, fx;
	
	private static String solution() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		q.offer(new int[] {hy, hx});
		
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();

			int remain = Math.abs(y-fy) + Math.abs(x-fx);
			if(remain <= 1000) return "happy";
			for(int i=0; i<N; i++) {
				int cy = cpos.get(i)[0];
				int cx = cpos.get(i)[1];
				int dist = Math.abs(y-cy) + Math.abs(x-cx);
				if(visited[i] || dist>1000) continue;
				q.offer(new int[] {cy, cx});
				visited[i] = true;
			}
		}
		return "sad";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			// 상근이네 집
			st = new StringTokenizer(br.readLine());
			hy = Integer.parseInt(st.nextToken());	
			hx = Integer.parseInt(st.nextToken());	
			
			// 편의점
			cpos = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				cpos.add(new int[] {Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken())
						});
			}
			
			// 펜타포트 락 페스티벌
			st = new StringTokenizer(br.readLine());
			fy = Integer.parseInt(st.nextToken());	
			fx = Integer.parseInt(st.nextToken());	
			sb.append(solution() + "\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}