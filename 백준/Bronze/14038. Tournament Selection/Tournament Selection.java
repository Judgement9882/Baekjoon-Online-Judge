import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception{
		// https://www.acmicpc.net/problem/5567
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int win = 0;
		for(int i = 0 ; i < 6; i++) {
			char c = br.readLine().charAt(0);
			if(c=='W') win++;
		}
		if(win>=5) System.out.println(1);
		else if (win>=3) System.out.println(2);
		else if (win>=1) System.out.println(3);
		else System.out.println(-1);
		

		br.close();
	}
}