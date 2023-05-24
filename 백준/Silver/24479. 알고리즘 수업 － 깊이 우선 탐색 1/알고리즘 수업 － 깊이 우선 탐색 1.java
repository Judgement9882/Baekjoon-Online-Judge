import java.io.*;
import java.util.*;
public class Main {
	static int N, M, R, cnt;
	static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[] vertex;
	static boolean[] v;
	static ArrayList<Integer> [] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		vertex = new int[N+1];
		v = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		// 오름차순
		for(int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		vertex[R] = 1;
		v[R] = true;
		cnt = 2;
		dfs(R);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) sb.append(vertex[i]).append("\n");
		System.out.println(sb);
		br.close(); 
	}
	
	static void dfs(int n) {
		for(Integer i : list[n]) {
			if(!v[i]) {// 방문하지 않았다면
				vertex[i] = cnt++;
				v[i] = true;
				dfs(i);
			}
		}
	}
}