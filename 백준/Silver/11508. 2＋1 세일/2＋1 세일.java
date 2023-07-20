import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer [] C = new Integer[N];
        for(int i = 0 ; i < N; i++){
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C, Collections.reverseOrder());
        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(i%3==0) continue;
            ans+=C[i-1];
        }
        System.out.println(ans);
        br.close();
    }
}