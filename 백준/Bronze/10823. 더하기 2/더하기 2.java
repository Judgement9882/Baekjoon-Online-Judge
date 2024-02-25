import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while(true){
            String temp = br.readLine();
            if(temp == null) break;
            str = str.concat(temp);
        }
        StringTokenizer st = new StringTokenizer(str, ",");
        int ans = 0;
        while(st.hasMoreTokens()){
            ans += Integer.parseInt(st.nextToken());
        }
        sb.append(ans);
        System.out.print(sb);
        br.close();
    }
}