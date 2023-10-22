import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while(N-->0){
            String temp = br.readLine();
            if(temp.contains("01") || temp.contains("OI")) ans++;
        }
        System.out.println(ans);
        br.close();
    }
}