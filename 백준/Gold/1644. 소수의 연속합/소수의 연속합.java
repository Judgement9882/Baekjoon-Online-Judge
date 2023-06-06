import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		if(N!=1) {
			if(N==2) ans= 1;
			else {
				ArrayDeque<Integer> dq = new ArrayDeque<>(); // 사용 숫자
				dq.addLast(2);
				int sum = 2; // 중간 저장값
				for(int i = 3; i <= N; i+=2) { // 2를 제외한 소수는 홀수 O(N/2)
					if(isPrime(i)) {
						dq.addLast(i);
						sum += i;
						
						if(sum >= N) { // 작으면 그냥 넘어감 
							if(sum == N) {
								ans++;
								sum -= dq.pollFirst();
//								System.out.println(sum);
							}
							else {
								while(sum > N) {
									sum -= dq.pollFirst();
									if(sum == N) ans++;
//									System.out.println("while : " + sum);
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	static boolean isPrime(int num) { //O(sqrt(N))
		for(int i = 2 ; i * i <= num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
}