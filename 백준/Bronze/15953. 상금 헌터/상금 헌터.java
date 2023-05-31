import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			if(a==0);
			else if(a==1) ans+=5000000;
			else if(a<=3) ans+=3000000;
			else if(a<=6) ans+=2000000;
			else if(a<=10) ans+=500000;
			else if(a<=15) ans+=300000;
			else if(a<=21) ans+=100000;
//			System.out.println("a : " + a);
//			System.out.println("1 : "+ans);
			if(b==0);
			else if(b==1) ans+=5120000;
			else if(b<=3) ans+=2560000;
			else if(b<=7) ans+=1280000;
			else if(b<=15) ans+=640000;
			else if(b<=31) ans+=320000;
//			System.out.println("b : " + b);
//			System.out.println("2 : "+ans);
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}