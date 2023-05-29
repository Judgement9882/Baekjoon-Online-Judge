import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double w = Double.parseDouble(br.readLine());
		double h = Double.parseDouble(br.readLine());
		double BMI = w / (h*h);
		if(BMI > 25) System.out.println("Overweight");
		else if (BMI >= 18.5) System.out.println("Normal weight");
		else System.out.println("Underweight");
	    br.close();
	}
}