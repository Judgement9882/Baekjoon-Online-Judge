import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String temp = br.readLine();
		if(temp.equals("NLCS")) sb.append("North London Collegiate School");
		if(temp.equals("BHA")) sb.append("Branksome Hall Asia");
		if(temp.equals("KIS")) sb.append("Korea International School");
		if(temp.equals("SJA")) sb.append("St. Johnsbury Academy");
		
		
		System.out.println(sb);
		br.close();
	}
}