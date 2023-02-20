import java.io.*;
import java.util.*;

public class Main{

	static int N, max_res, min_res;
	static char[] opt;
	static int[] num, opt_num;
	
	static void perm(int cnt) {
		if(cnt == N-1) {
			int sum = num[0];
			for(int i = 0; i < N-1; i++) {
				if(opt_num[i] == 0) {
					sum += num[i+1];
				}
				else if(opt_num[i] == 1) {
					sum -= num[i+1];
				}
				else if(opt_num[i] == 2) {
					sum *= num[i+1];
				}
				else if(opt_num[i] == 3) {
					sum /= num[i+1];
				}
			}
			
			max_res = Math.max(max_res, sum);
			min_res = Math.min(min_res, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(opt[i] > 0) {
				opt[i]--;
				opt_num[cnt] = i;
				perm(cnt+1);
				opt[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		max_res = Integer.MIN_VALUE;
		min_res = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		num = new int[N];
		for(int i= 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		opt = new char[4];
		
		for(int i= 0; i < 4; i++) {
			int temp = Integer.parseInt(st.nextToken());
			opt[i] += temp;
		}
		
		opt_num = new int[N-1];
		perm(0);
		
		sb.append(max_res).append("\n").append(min_res);
		System.out.println(sb);
		br.close();
	}
}
