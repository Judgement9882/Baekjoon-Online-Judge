import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i = A; i <= B; i++){
            if(Math.abs(i-K) <= X) ans++;
        }
        System.out.print(ans==0?"IMPOSSIBLE":ans);
        br.close();
    }
}