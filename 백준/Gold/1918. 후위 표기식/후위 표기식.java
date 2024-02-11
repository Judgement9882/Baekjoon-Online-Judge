import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();
        ArrayDeque<Character> s = new ArrayDeque<>();

        for(int i=0;i<input.length;i++) {
            // A~Z
            if(input[i]>=65) {
                sb.append(input[i]);
            }
            // stack is empty || top == '(' || input == '('
            else if(s.isEmpty() || input[i]=='(') {
                s.push(input[i]);
            }
            else {
                switch (input[i]) {
                    case '+': case '-':
                        while(!s.isEmpty() && s.peek()!= '(') {
                            sb.append(s.pop());
                        }
                        s.push(input[i]);
                        break;
                    case '*' : case '/':
                        while(!s.isEmpty() && (s.peek()== '*' || s.peek()=='/' )) {
                            sb.append(s.pop());
                        }
                        s.push(input[i]);
                        break;
                    case ')':
                        while(!s.isEmpty() && s.peek()!='(') {
                            sb.append(s.pop());
                        }
                        s.pop();
                        break;
                }
            }
        }
        while(!s.isEmpty()) sb.append(s.pop());
        System.out.println(sb);
    }
}