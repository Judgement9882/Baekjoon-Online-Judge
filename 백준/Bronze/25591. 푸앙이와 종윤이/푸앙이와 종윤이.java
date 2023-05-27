import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int a = 100-A;
		int b = 100-B;
		int c = 100-(a+b);
		int d = a*b;
		int q = d/100;
		int r = d%100;
		
		int front = c;
		int back = d;
		if(d>=100) {
			front = c+q;
			back = r;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(" ").append(b).append(" ").append(c).append(" ").append(d).append(" ").append(q).append(" ").append(r).append("\n").append(front).append(" ").append(back);
		System.out.println(sb);
		br.close();
	}
}