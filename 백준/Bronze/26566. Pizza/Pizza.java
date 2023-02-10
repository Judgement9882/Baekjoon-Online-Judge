import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(N-- > 0) {
			double A1, P1;
			st = new StringTokenizer(br.readLine(), " ");
			A1 = Double.parseDouble(st.nextToken());
			P1 = Double.parseDouble(st.nextToken());

			double R1, P2;
			st = new StringTokenizer(br.readLine(), " ");
			R1 = Double.parseDouble(st.nextToken());
			P2 = Double.parseDouble(st.nextToken());
			
			if(A1/P1 > R1/P2*Math.PI*R1) System.out.println("Slice of pizza");
			else System.out.println("Whole pizza");
		}
		
	}
}
