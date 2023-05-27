import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int X = 0, Y=0;
		while(N-->0) {
			char S = br.readLine().charAt(0);
			if(S=='D') X++;
			else Y++;
			if(Math.abs(X-Y) >= 2) {
				while(N-->0) {
					br.readLine();
				}
				break;
			}
		}
		System.out.println(X+":"+Y);
		
		StringBuilder sb = new StringBuilder();
		System.out.println(sb);
		br.close();
	}
}