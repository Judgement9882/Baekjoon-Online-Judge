import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			String temp = br.readLine();
			sb.append(temp.charAt(0));
			for(int i = 1; i < temp.length(); i++) {
				if(temp.charAt(i-1) != temp.charAt(i)) sb.append(temp.charAt(i));
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	    br.close();
	}
}