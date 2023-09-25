import java.io.*;
import java.util.*;
public class Main {
    static ArrayDeque<Integer> deq = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    deq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if(!deq.isEmpty()) sb.append(deq.pollFirst()).append("\n");
                    else sb.append("-1\n");
                    break;
                case 4:
                    if(!deq.isEmpty()) sb.append(deq.pollLast()).append("\n");
                    else sb.append("-1\n");
                    break;
                case 5:
                    sb.append(deq.size()).append("\n");
                    break;
                case 6:
                    if(deq.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case 7:
                    if(!deq.isEmpty()) sb.append(deq.peekFirst()).append("\n");
                    else sb.append("-1\n");
                    break;
                case 8:
                    if(!deq.isEmpty()) sb.append(deq.peekLast()).append("\n");
                    else sb.append("-1\n");
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }


}