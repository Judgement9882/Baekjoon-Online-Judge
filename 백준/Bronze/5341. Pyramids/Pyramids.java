import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int N = sc.nextInt();
			if(N==0) break;
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				ans += i;
			}
			System.out.println(ans);
		}
		
		
	}
}
