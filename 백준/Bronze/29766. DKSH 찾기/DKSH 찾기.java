import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int ans = 0;
        for(int i = 0 ; i <= temp.length()-4; i++){
            if(temp.charAt(i) == 'D'){
                if(temp.charAt(i+1) == 'K'){
                    if(temp.charAt(i+2) == 'S'){
                        if(temp.charAt(i+3) == 'H'){
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.print(ans);
        br.close();
    }
}