import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String temp = br.readLine();
			if(temp.equals("TTYL")) {
				sb.append("talk to you later\n");
				break;
			}
			else if(temp.equals("CU")) sb.append("see you");
			else if(temp.equals(":-)")) sb.append("I’m happy");
			else if(temp.equals(":-(")) sb.append("I’m unhappy");
			else if(temp.equals(";-)")) sb.append("wink");
			else if(temp.equals(":-P")) sb.append("stick out my tongue");
			else if(temp.equals("(~.~)")) sb.append("sleepy");
			else if(temp.equals("TA")) sb.append("totally awesome");
			else if(temp.equals("CCC")) sb.append("Canadian Computing Competition");
			else if(temp.equals("CUZ")) sb.append("because");
			else if(temp.equals("TY")) sb.append("thank-you");
			else if(temp.equals("YW")) sb.append("you’re welcome");
			else sb.append(temp);
			sb.append("\n");
		}
		System.out.println(sb);
	    br.close();
	}
	
}