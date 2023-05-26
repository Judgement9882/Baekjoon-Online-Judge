import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		if(temp.charAt(0)=='5' && temp.charAt(1)=='5' && temp.charAt(2)=='5') System.out.println("YES");
		else System.out.println("NO");
		br.close();
	}
}