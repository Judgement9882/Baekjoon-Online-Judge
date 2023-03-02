import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int S = 0;
		
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			if(command.equals("all")){
				S = (1<<21) - 2;
			}
			else if(command.equals("empty")) {
				S = 0;
			}else {
				int num = Integer.parseInt(st.nextToken());
				
				if(command.equals("add")) S |= (1<<num);
				else if (command.equals("remove")) S &= (~(1<<num));
				else if (command.equals("check")) {
					if((S & (1<<num)) != 0 ) sb.append("1\n");
					else sb.append("0\n");
				}
				else if (command.equals("toggle")) {
					S ^= (1<<num);
				}
			}
//			System.out.println("+++++++++++");
//			System.out.println(S);
//			System.out.println("_)_)_)_)_)_)_)_)_)");
		}
		System.out.println(sb);
		br.close();
	}
}
