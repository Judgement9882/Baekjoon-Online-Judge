import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i = 0 ;i < K; i++) {
			ans += A[i];
		}
		int temp = ans;
		for(int i = K; i < N; i++) {
			temp = temp - A[i-K] + A[i];
			ans = Math.max(temp, ans);
		}
		System.out.println(ans);
		
		br.close();
	}
}