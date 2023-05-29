import java.io.*;
import java.util.*;
public class Main {	
	
	static int N, M;
	static int [] p;
	static int[][] g;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		g = new int[N+1][N+1];
		makeSet();
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
				if(g[i][j] == 1) unionSet(i, j);
			}
		}
		String answer = "YES";
		StringTokenizer st = new StringTokenizer(br.readLine());
		int parent = findSet(Integer.parseInt(st.nextToken()));
		for(int i = 1; i < M; i++) {
			if(parent != findSet(Integer.parseInt(st.nextToken()))){
				answer = "NO";
				break;
			}
		}
		System.out.println(answer);
	    br.close();
	}
	
	static void makeSet() {
		p = new int[N+1];
		for(int i = 1; i <= N; i++ ) p[i] = i;
	}
	
	static int findSet(int a) {
		if(p[a] == a) return a;
		else return p[a] = findSet(p[a]);
	}
	
	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	
}