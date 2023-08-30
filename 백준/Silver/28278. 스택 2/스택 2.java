import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order == 1) stack.push(Integer.parseInt(st.nextToken()));
            else if (order==2){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else {
//                    ArrayDeque<Integer> temp = new ArrayDeque<>();
                    int out = stack.pop();

                    sb.append(out).append("\n");
//                    while (!stack.isEmpty()) {
//                        temp.offer(stack.pop());
//                    }
//                    while (!temp.isEmpty()) {
//                        stack.push(temp.poll());
//                    }
                }
            }else if (order==3){
                sb.append(stack.size()).append("\n");
            }else if (order==4){
                if(stack.isEmpty()) sb.append(1).append("\n");
                else                sb.append(0).append("\n");
            }else if (order==5){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else                sb.append(stack.peek()).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}