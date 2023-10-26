import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        String temp = br.readLine();
        for(int i = 0; i < temp.length()-3; i++){
            if(temp.charAt(i) == 'k' && temp.charAt(i+1) == 'i' && temp.charAt(i+2) == 'c' && temp.charAt(i+3) == 'k') ans++;
        }
        System.out.println(ans);
        br.close();
    }
}