import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int prev = 1;
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += i;
            if(N==sum){
                ans++;
                sum -= prev;
                prev++;
            }else if (N < sum){
                while(N < sum){
                    sum -= prev;
                    prev++;
                    if(N==sum) ans++;
                }
            }
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}