import java.io.*;
import java.util.*;
public class Main {
	static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if(B == A) System.out.println("Anything");
		else if (B > A) System.out.println("Bus");
		else if (B < A) System.out.println("Subway");
		br.close(); 
	}
}