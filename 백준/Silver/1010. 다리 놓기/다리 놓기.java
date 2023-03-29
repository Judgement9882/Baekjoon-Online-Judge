import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			// 절반 이상이면 처리해줌
			if(N/2 < K) K = N-K;
			
			int [][] B = new int[N+1][K+1];
			for(int i = 0; i <= N; i++) {
				for(int j = 0, end = Math.min(i, K); j <= end; j++) {
					if(j == 0 || j == i) B[i][j] = 1;
					else B[i][j] = B[i-1][j-1] + B[i-1][j];
				}
			}
			System.out.println(B[N][K]);
		}
		br.close();
	}
}