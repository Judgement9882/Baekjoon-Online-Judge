import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			char order = st.nextToken().charAt(0);
			st = new StringTokenizer(br.readLine(), " ");
			if(order == 'C') {
				for(int j = 0 ; j < N; j++) {
					int temp = st.nextToken().charAt(0) - 64;
					sb.append(temp).append(" ");
				}
				sb.append("\n");
			}
			else {
				for(int j = 0 ; j < N; j++) {
					char temp = (char) (Integer.parseInt(st.nextToken()) + 64);
					
					sb.append(temp).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
