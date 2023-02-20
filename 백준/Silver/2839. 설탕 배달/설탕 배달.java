import java.io.*;
import java.util.*;

public class Main{
	
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int [] num = new int[5000+1];
		
		num[3] = 1;
		num[4] = 0;
		num[5] = 1;
		
		if(N < 6) {
			System.out.println(num[N]==0?"-1":num[N]);
			System.exit(0);
		}
		
		for(int i = 6; i <= N; i++) {
			if(num[i-3] != 0 && num[i-5] != 0)
			num[i] = Math.min(num[i-3]+1, num[i-5]+1);
			
			else if (num[i-3] == 0) {
				if(num[i-5] == 0) { // 둘다 0이면 컨티뉴
					continue;
				}
				else {
					num[i] = num[i-5] + 1;
				}
			}
			else if(num[i-5] == 0) {
				num[i] = num[i-3] + 1;
			}
		}
		
		System.out.println(num[N]==0?"-1":num[N]);
	}
}
