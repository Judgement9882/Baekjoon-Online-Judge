import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] num = new int[N];
		for(int i = 0 ; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		int sum = num[0];

		for(int i = 0 ; i < N-1; i++) {
			if(num[i+1]-num[i]==1) continue;
			sum += num[i+1];
		}
		System.out.println(sum);
		
	}
}
