import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(1);
			System.exit(0);
		}
		List<Integer> l = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) l.add(i);
		while(true) {
			sb.append(l.remove(0)).append(" ");
			if(l.size()==1) break;
			l.add(l.remove(0));
		}
		sb.append(l.remove(0));
		System.out.println(sb);
		br.close(); 
	}
}