import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [][] knap = new int[N+1][K+1];
		int [][] pack = new int[N+1][];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			pack[i] = new int[] {W, V};
		}
		for(int i = 1; i <= N; i++) {
			for(int w = 1; w <= K; w++) {
				if(pack[i][0] > w) { // 물건이 더 큰 경우
					knap[i][w] = knap[i-1][w];
				}
				
				else { // 물건이 더 작거나 같은 경우
					// 물건을 넣을지 말지 선택해야함
					knap[i][w] = Math.max(pack[i][1] + knap[i-1][w-pack[i][0]], knap[i-1][w]);
				}
			}
		}
		System.out.println(knap[N][K]);
		br.close();
	}
}