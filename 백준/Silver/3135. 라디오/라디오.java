import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int ans = Math.abs(B-A);
        while(N-->0){
            int num = Integer.parseInt(br.readLine());
            ans = Math.min(ans, Math.abs(num-B) + 1);
        }
        System.out.println(ans);
        br.close();
    }
}