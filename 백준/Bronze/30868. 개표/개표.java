import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            int num = Integer.parseInt(br.readLine());
            while(num > 0){
                if(num >= 5){
                    num -= 5;
                    sb.append("++++ ");
                }
                else{
                    for(int i = 0 ; i < num; i++){
                        sb.append("|");
                    }
                    num = 0;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}