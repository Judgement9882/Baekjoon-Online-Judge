import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String temp = "";
//		while((temp = br.readLine()) != null) {
//			System.out.println(temp);
//		}
		StringBuilder sb = new StringBuilder();
		sb.append("  ___  ___  ___").append("\n");
		sb.append("  | |__| |__| |").append("\n");
		sb.append("  |           |").append("\n");
		sb.append("   \\_________/").append("\n");
		sb.append("    \\_______/").append("\n");
		sb.append("     |     |").append("\n");
		sb.append("     |     |").append("\n");
		sb.append("     |     |").append("\n");
		sb.append("     |     |").append("\n");
		sb.append("     |_____|").append("\n");
		sb.append("  __/       \\__").append("\n");
		sb.append(" /             \\").append("\n");
		sb.append("/_______________\\");
		System.out.println(sb);
		br.close();
	}
}