import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			long d = Integer.parseInt(st.nextToken());
			
			if(a*b > c*d) sb.append("TelecomParisTech\n");
			else if (a*b < c*d) sb.append("Eurecom\n");
			else sb.append("Tie\n");
		}
		System.out.println(sb);
	}
}

/*
                                             
                    
                  
                  
                 
                                             

*/