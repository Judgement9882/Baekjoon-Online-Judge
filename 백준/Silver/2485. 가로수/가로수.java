import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 입력 받을때 모두 처리
		int gcd = 0;
		int front = 0;
		int back = 0;
		int max_num = -1, min_num = Integer.MAX_VALUE;
		for(int i = 0 ; i < N; i++) {
			if(i==0) { // 최초
				front = Integer.parseInt(br.readLine());
			}
			else if(i==1) { // 두번째
				back = Integer.parseInt(br.readLine());
				gcd = back - front;
				max_num = Math.max(front, back);
				min_num = Math.min(front, back);
				front = back;
			}
			else {
				back = Integer.parseInt(br.readLine());
				if(gcd!=1) gcd = cal_gcd(gcd, back - front);
				max_num = Math.max(max_num, back);
				min_num = Math.min(min_num, back);
				front = back;
			}
		}
		System.out.println((max_num - min_num) / gcd - N + 1);
		br.close();
	}
	
	static int cal_gcd(int a, int b) {
		int c;
		while(b!=0) {
			c = a%b;
			a = b;
			b = c;
		}
		return a;
	}
}