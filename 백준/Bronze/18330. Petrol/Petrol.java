import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine())+60;
		if(M>=N) System.out.println(N*1500);
		else System.out.println(M*1500 + (N-M)*3000);
		br.close();
	}
}