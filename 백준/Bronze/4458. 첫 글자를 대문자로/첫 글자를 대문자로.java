import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			String temp = br.readLine();
			sb.append(temp.substring(0,1).toUpperCase()).append(temp.substring(1)).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}
}