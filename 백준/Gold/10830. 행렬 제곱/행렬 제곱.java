import java.io.*;
import java.util.*;
public class Main {
	static int mod = 1_000, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int [][] Matrix = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				Matrix[i][j] = Integer.parseInt(st.nextToken()) % mod;
			}
		}
		Matrix = func(Matrix, B);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				sb.append(Matrix[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static int[][] func(int[][] M, long B){
		if(B==1) return M;
		int[][] temp = func(M, B/2);
		temp = calcMultiply(temp, temp);
		// 짝 홀에 맞춰서
		if(B%2==0) return temp;
		else return calcMultiply(temp, M);
	}
	
	static int[][] calcMultiply(int[][] M1, int[][] M2){
		int[][] temp = new int[N][N];
		for(int ti = 0; ti < N; ti++) {
			for(int tj = 0; tj < N; tj++) {
				int val = 0;
				for(int pos = 0; pos < N; pos++) {
					val += M1[ti][pos] * M2[pos][tj];
					val %= mod;
				}
				temp[ti][tj] = val;
			}
		}
		return temp;
	}
	
	
}