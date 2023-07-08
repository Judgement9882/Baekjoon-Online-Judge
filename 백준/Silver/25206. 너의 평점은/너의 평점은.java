import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double ans = 0.0;
		double numOfSubject = 0;
		for(int i = 0 ; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String subject = st.nextToken();
			Double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			if(grade.charAt(0) == 'P') continue;
			numOfSubject+=score;
			ans += score * calGrade(grade);
//			System.out.println(ans);
//			System.out.println(numOfSubject);
		}
		System.out.println(ans / numOfSubject);
		br.close();
	}
	
	static double calGrade(String grade) {
		if(grade.equals("A+")) return 4.5;
		else if(grade.equals("A0")) return 4.0;
		else if(grade.equals("B+")) return 3.5;
		else if(grade.equals("B0")) return 3.0;
		else if(grade.equals("C+")) return 2.5;
		else if(grade.equals("C0")) return 2.0;
		else if(grade.equals("D+")) return 1.5;
		else if(grade.equals("D0")) return 1.0;
		else return 0.0;
	}
}