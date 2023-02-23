import java.io.*;
import java.util.*;

public class Main{
	static int N, K;
	static int[] board;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[1000001];
		board[N] = 1;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(N);
		
		while(board[K] == 0) {
			int cur = q.poll();
			int [] temp = {cur-1, cur+1, cur*2}; 
			
			for(int i : temp) {
				// 범위 이탈
				if(i < 0 || i > 100000) continue;
				
				// 이미 방문했다면
				if(board[i] != 0) continue;
				
				// 갱신
				board[i] = board[cur] + 1;
				q.offer(i);
			}
		}
		
		System.out.println(board[K]-1);
		
		br.close();
	}
}
