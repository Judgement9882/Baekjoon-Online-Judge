import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1, o2);
        });
        while(N-->0) pq.offer(Integer.parseInt(br.readLine()));
        int ans = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            ans += a+b;
            pq.offer(a+b);
        }
        pq.clear();
        sb.append(ans);
        System.out.print(sb);
        br.close();
    }
}