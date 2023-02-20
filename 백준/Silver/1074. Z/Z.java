import java.io.*;
import java.util.*;
public class Main{
	static int N, r, c, num, ans;
	static void cut (int x, int y, int size) {
		if(size == 1) {
			if(x == r && y == c) ans = num;
			return;
		}
		int half = size/2;
		
		if(r < x+half && c < y+half) {
			cut(x, y, half);	
		}
		else if (r < x+half && c >= y+half) {
			num += half*half;
			cut(x, y+half, half);	
		}
		else if (r >= x+half && c < y+half) {
			num += 2*half*half;
			cut(x+half, y, half);
		}
		else {
			num += 3*half*half;
			cut(x+half, y+half, half);			
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		num = 0;
		cut(0, 0, 2 << N);
		System.out.println(ans);
		br.close();
	}
}
