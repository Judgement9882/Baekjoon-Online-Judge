import java.io.*;
import java.util.*;
public class Main {
	static int[] originLove = {0, 0, 0, 0};
	static int[] newLove;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String yeondu = br.readLine();
		for(int i = 0; i < yeondu.length(); i++) {
			char temp = yeondu.charAt(i);
			if(temp=='L') originLove[0]++;
			else if(temp=='O') originLove[1]++;
			else if(temp=='V') originLove[2]++;
			else if(temp=='E') originLove[3]++;
		}
		
		int N = Integer.parseInt(br.readLine());
		String ans = "ZZZZZZZZZZZZZZZZZZZZZZ";
		long percent = 0;
		while(N-->0) {
			init();
			String teamName = br.readLine();
			for(int i = 0; i < teamName.length(); i++) {
				char temp = teamName.charAt(i);
				if(temp=='L') newLove[0]++;
				else if(temp=='O') newLove[1]++;
				else if(temp=='V') newLove[2]++;
				else if(temp=='E') newLove[3]++;
			}
			
			long result = calc();
//			System.out.println(teamName+""+result);
			if(result == percent) {
				if(ans.compareTo(teamName) > 0) {
					ans = teamName;
				}
			}
			else if (result > percent) {
				percent = result;
				ans = teamName;
			}
		}
		System.out.println(ans);
//		System.out.println(percent);
		br.close(); 
	}
	
	static void init() {
		newLove = new int[4];
		for(int i = 0 ; i < 4; i++) newLove[i] = originLove[i];
	}
	
	static long calc() {
		int L = newLove[0];
		int O = newLove[1];
		int V = newLove[2];
		int E = newLove[3];
		
		return ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) % 100;
	}
}