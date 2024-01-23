import java.io.*;
import java.util.*;
public class Main {
    static class Input{
        int num;
        String order;
        Input(int num, String order){
            this.num = num;
            this.order = order;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        end : while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            // init
            ArrayDeque<Input> q = new ArrayDeque<>();
            boolean[] vis = new boolean[10000];
            q.offer(new Input(A, ""));
            vis[A] = true;

            while(!q.isEmpty()){
                Input cur = q.poll();
                int n = cur.num;
                String str = cur.order;
                
                if(n == B){
                    sb.append(str).append("\n");
                    continue end;
                }
                
                int D, S, L, R;
                D = (n*2)%10000;
                if(!vis[D]){
                    vis[D] = true;
                    q.add(new Input(D, str+"D"));
                }
                
                S = n==0 ? 9999 : n-1;
                if(!vis[S]){
                    vis[S] = true;
                    q.add(new Input(S, str+"S"));
                }
                
                L = (n%1000)*10 + (n/1000);
                if (!vis[L])
                {
                    vis[L] = true;
                    q.add(new Input(L, str+"L"));
                }
                
                R = n/10 + (n%10)*1000;
                if (!vis[R])
                {
                    vis[R] = true;
                    q.add(new Input(R, str+"R"));
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}