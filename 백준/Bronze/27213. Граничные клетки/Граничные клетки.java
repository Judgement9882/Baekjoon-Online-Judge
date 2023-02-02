import java.io.*;
import java.util.*;

public class Main {
	
	public static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		if(M >= 3 && N >= 3) System.out.println(N*M - (N-2)*(M-2));
		else System.out.println(N*M);
	}
}
