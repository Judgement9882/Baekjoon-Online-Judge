import java.io.*;
import java.util.*;
public class Main {
	static int N, M, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [][] Matrix1 = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				Matrix1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st= new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int [][] Matrix2 = new int[M][K];
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < K; j++) {
				Matrix2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] Matrix = new int[N][K]; 
		Matrix = calcMultiply(Matrix1, Matrix2);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < K; j++) {
				sb.append(Matrix[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static int[][] calcMultiply(int[][] M1, int[][] M2){
		int[][] temp = new int[N][K];
		for(int ti = 0; ti < N; ti++) {
			for(int tj = 0; tj < K; tj++) {
				int val = 0;
				for(int pos = 0; pos < M; pos++) {
					val += M1[ti][pos] * M2[pos][tj];
				}
				temp[ti][tj] = val;
			}
		}
		return temp;
	}
	
	
}