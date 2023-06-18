import java.io.*;
import java.util.*;
public class Main {
	static int maxNode = 0, maxLen = 0;
	static ArrayList<Node>[] g;
	static class Node{
		int des;
		int weight;
		public Node(int des, int weight) {
			this.des = des;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		g = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) g[i] = new ArrayList<>();
		for(int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			int s = Integer.parseInt(st.nextToken())-1;
			while(true) {
				int e = Integer.parseInt(st.nextToken())-1;
				if(e==-2) break;
				int w = Integer.parseInt(st.nextToken());
				g[s].add(new Node(e,w));
				g[e].add(new Node(s,w));	
			}
			
		}
		
		maxNode = 0;
		maxLen = 0;
		bfs(0, n); // 가장 멀리있는 노드 찾기
		maxLen = 0;
		bfs(maxNode, n); // 멀리있는 노드에서 더 멀리있는 노드 찾기
		System.out.println(maxLen);
		br.close();
	}
	
	static void bfs(int start, int n) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.offer(new Node(start, 0));
		boolean [] v = new boolean[n+1];
		v[start] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(Node temp : g[cur.des]) {
				if(v[temp.des]) continue;
				v[temp.des] = true;
				int weight = cur.weight+temp.weight;
				q.offer(new Node(temp.des, weight));
				
				if(maxLen < weight) { // 최대 길이 노드 갱신
					maxLen = weight;
					maxNode = temp.des;
				}
			}
		}
	}
}