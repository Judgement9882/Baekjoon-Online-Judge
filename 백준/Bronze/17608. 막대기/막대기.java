import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		int height = A[N-1];
		int cnt = 1;
		for(int i = N-2; i >= 0; i--) {
			if(A[i] > height) {
				cnt++;
				height = A[i];
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}