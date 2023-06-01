import java.io.*;
import java.util.*;

public class Main {
	
	static int [] dice = {1, 2, 3, 4, 5, 6};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사다리 수
		int M = Integer.parseInt(st.nextToken()); // 뱀 수
		
		int board[] = new int[101];
		boolean visit[] = new boolean[101];
		for(int i = 1; i <= 100; i++)board[i] = i;
		
		for(int i = 0 ;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u] = v;
		}
		for(int i = 0 ;i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u] = v;
		}
		
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1, 0});
		visit[1] = true;
		while(!q.isEmpty()) {
			int []cur = q.poll();
			int pos = cur[0]; // 현재위치
			int dist = cur[1]; // 이동거리
			for(int num : dice) {
				int nextIndex = pos + num;
				// 만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다. 
				if(nextIndex > 100) continue;
				if(visit[nextIndex]) continue;
				// 플레이어는 주사위를 굴려 나온 수만큼 이동해야 한다.
				int nextPos = board[nextIndex];
				
				if(nextPos == 100) {
					System.out.println(dist+1);
					System.exit(0);
				}
//				System.out.println("이전위치 : " + pos + "지금 위치 : " + nextPos);
				q.offer(new int[] {nextPos, dist+1});
				visit[nextPos] = true;
			}
		}
		
//		System.out.println(sb);
		br.close();
	}
}