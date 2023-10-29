import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 15;
        String str[] = new String[N];
        while(N-->0){
            str[14-N] = br.readLine();
        }
        for(int i = 0; i < 15; i++){
            String temp = str[i];
            if(temp.contains("w")){
                System.out.println("chunbae");
                break;
            }
            if(temp.contains("b")){
                System.out.println("nabi");
                break;
            }
            if(temp.contains("g")){
                System.out.println("yeongcheol");
                break;
            }
        }
        br.close();
    }
}