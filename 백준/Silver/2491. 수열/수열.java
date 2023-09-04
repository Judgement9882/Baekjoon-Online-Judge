import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int inc = 1;
        int dec = 1;
        int ans = 1;
        while(N-->1){
            int next = Integer.parseInt(st.nextToken());
            // 증가
            if(prev < next) {
                inc++;
                ans = Math.max(ans, dec);
                dec = 1;
            }
            else if (prev > next){
                ans = Math.max(ans, inc);
                inc = 1;
                dec++;
            }
            else{
                inc++;
                dec++;
            }
            prev = next;
        }
        ans = Math.max(ans, Math.max(inc, dec));
        System.out.print(ans);
        br.close();
    }
}