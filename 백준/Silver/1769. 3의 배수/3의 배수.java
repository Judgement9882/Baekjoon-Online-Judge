import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String X = br.readLine();
        int ans = 0;
        while(X.length() > 1){
            int num = 0;
            for(int i = 0; i < X.length(); i++){
                num += X.charAt(i) - '0';
            }
            X = String.valueOf(num);
            ans++;
        }
        sb.append(ans).append("\n");
        if(X.equals("3") || X.equals("6") || X.equals("9"))  sb.append("YES");
        else        sb.append("NO");
        System.out.println(sb);
        br.close();
    }
}