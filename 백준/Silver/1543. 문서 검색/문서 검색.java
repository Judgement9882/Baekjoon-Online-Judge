import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String search = br.readLine();
        int ans = 0;
        for(int i = 0; i < origin.length(); i++){
            boolean flag = true;
            for(int j = 0; j < search.length(); j++){
                if(i+j >= origin.length() || origin.charAt(i+j) != search.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans++;
                i += search.length()-1;
            }
        }
        System.out.print(ans);
        br.close();
    }
}