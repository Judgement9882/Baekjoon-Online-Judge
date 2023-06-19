import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static ArrayList<Integer>[] next, prev;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		next = new ArrayList[N+1]; // 진출차수
		prev = new ArrayList[N+1]; // 진입차수
		for(int i = 0; i <= N; i++) {
			next[i] = new ArrayList<>();
			prev[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int front = Integer.parseInt(st.nextToken());
			for(int j =1 ; j < num; j++) {
				int back = Integer.parseInt(st.nextToken());
				next[front].add(back);
				prev[back].add(front);
				front = back;
			}
		}
		
		// 진입차수가 0인 노드를 q에 넣음
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int cnt = 0; // 진입차수가 0인 노드의 개수 구하기
		for(int i = 1; i <= N; i++) {
			if(prev[i].isEmpty()) {
				cnt++;
				q.offer(i);
				sb.append(i).append("\n");
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int temp : next[cur]) {
				for(int i = 0; i < prev[temp].size(); i++) {
					if(prev[temp].get(i) == cur) {
						prev[temp].remove(i);
						break;
					}
				}
				if(prev[temp].isEmpty()) {
					cnt++;
					q.offer(temp);
					sb.append(temp).append("\n");
				}
			}
		}
		
		if(cnt==N) System.out.println(sb);
		else System.out.println(0);
		br.close();
	}
}