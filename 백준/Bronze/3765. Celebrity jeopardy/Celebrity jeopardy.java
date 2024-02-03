import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String temp = br.readLine();
            if(temp==null) break;
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}