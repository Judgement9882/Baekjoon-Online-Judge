import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] num = new int[10];
		int three = 0;
		for(int i = 0 ; i < str.length(); i++) {
			int temp = str.charAt(i)-'0';
			num[temp]++;
			three += temp;
		}
		three %= 3;
		if(num[0] < 1 || three != 0) {
			System.out.println("-1");
		}else {
			StringBuilder sb = new StringBuilder();
			for(int i = 9; i >= 0; i--) {
				while(num[i]-- > 0) {
					sb.append(Integer.toString(i));
				}
			}
			System.out.println(sb);
		}
		br.close();
	}
}