import java.io.*;
import java.util.*;
public class Main {
	static int [] visit;
	static int v = 1;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)list[i] = new ArrayList<>();
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		visit = new int[N+1];
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= N; i++) sb.append(visit[i]).append("\n");
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int r) {
		visit[r] = v++;
		Collections.sort(list[r], Collections.reverseOrder());
		
		for(int i : list[r]) {
			if(visit[i]==0) {
				dfs(i);
			}
		}
	}
}