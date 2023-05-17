import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] score = new int[6];
		for(int i = 1; i <= 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) score[i] += Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int ans_num = 0;
		for(int i = 1; i<=5; i++) {
			if(score[i] > ans_num) {
				ans_num = score[i];
				ans = i;
			}
		}
		System.out.println(ans+" "+ans_num);
		
		br.close();
	}
}