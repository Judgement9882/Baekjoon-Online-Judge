import java.io.*;
import java.util.*;
public class Main {
	static int N, M, adj[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj=new int[N+1][N+1]; // 자신보다 키가 큰 관계 표현
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1; // 유향
		}
		
		for(int k = 1; k <= N; k++) { // 경
			for(int i = 1; i <= N; i++) { // 출
				if(i==k || adj[i][k] == 0) continue; // 같거나 i -> k 관계 없으면 노필요
				for(int j = 1; j <= N; j++) { // 도
					if(adj[i][j]==1) continue; // 이미 관계를 알면 필요없음
					adj[i][j] = adj[k][j];
				}
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				adj[i][0] += adj[i][j]; // 자신보다 키가 큰 학생수 누적
				adj[0][j] += adj[i][j]; // 자신보다 키가 작은 학생수 누적
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(adj[i][0] + adj[0][i] == N-1) ans++;
		}
		System.out.println(ans);
		br.close();
	}
}