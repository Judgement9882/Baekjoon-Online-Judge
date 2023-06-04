import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String temp = "";
//		while((temp = br.readLine()) != null) {
//			System.out.println(temp);
//		}
		
		int index = 1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			String temp = br.readLine();
			if(temp.length() == 1 && temp.charAt(0) == '0') break;
			
			sb.append("Case ").append(index++).append(": Sorting... done!").append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}