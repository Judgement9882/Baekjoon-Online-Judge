import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 사다리 수
			
			if(a==0) break;
			
			int num = 1;
			for(int i = 0; i < a; i++) {
				num *= Integer.parseInt(st.nextToken());
				num -= Integer.parseInt(st.nextToken());
			}
			sb.append(num).append("\n");
		}
		
		
		
		System.out.println(sb);
		br.close();
	}
}