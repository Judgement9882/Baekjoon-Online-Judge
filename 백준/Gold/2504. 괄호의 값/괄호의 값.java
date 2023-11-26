import java.io.*;
import java.util.*;

public class Main {
	// stack의 사이즈에 따라 나온 수를 저장하는 배열
	static int [] depth = new int[31];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		 
		ArrayDeque<Character> s = new ArrayDeque<>();
		boolean right = true;
		end : for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// 여는 괄호 처리 (, [
			if(ch == '(' || ch == '[') {
				// 일단 넣음
				s.push(ch);
			}else { // 닫는 괄호
				if(ch == ')') {
					// top을 확인해서 (가 아니라면 안됨
					if(s.isEmpty() || s.peekFirst() != '(') {
						right = false;
						break end;
					}
					s.pop();
					calc(s.size(), 2);
					
				}else if(ch==']') {
					// top을 확인해서 [가 아니라면 안됨
					if(s.isEmpty() || s.peekFirst() != '[') {
						right = false;
						break end;
					}
					s.pop();
					calc(s.size(), 3);
				}
			}
		}
		// 올바르지 않다면 0출력
		if(!right) sb.append("0");
		else sb.append(depth[0]);
		System.out.println(sb);
		br.close();
	}
	
	// size 는 스택의 크기
	// type은 ( 인지 [ 인지
	static void calc(int size, int type) {
		// 1. depth[size+1] 값이 0인지 확인
		if(depth[size+1] == 0) {
			// 2. 0이라면 그냥 더하면 됨
			depth[size] += type;
		}
		else {
			// 3. 0이 아니라면 size+1의 값과 곱해서 더하고 초기화.
			depth[size] += depth[size+1] * type;
			depth[size+1] = 0;
		}
	}
}