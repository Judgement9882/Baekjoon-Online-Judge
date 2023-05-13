import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> a = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while(N-->0) a.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		while(M-->0) a.add(Integer.parseInt(st.nextToken()));
		Collections.sort(a);
		for(int i : a) sb.append(i).append(" "); 
		System.out.println(sb);
		br.close();
	}
}