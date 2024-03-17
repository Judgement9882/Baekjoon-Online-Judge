import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.parseInt(br.readLine())%7==2?1:0);
        System.out.println(sb);
        br.close();
    }
}