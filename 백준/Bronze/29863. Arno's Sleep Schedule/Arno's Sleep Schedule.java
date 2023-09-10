import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sleep = Integer.parseInt(br.readLine());
        int awake = Integer.parseInt(br.readLine());
        if(awake > sleep) System.out.print(awake-sleep);
        else System.out.print(24-sleep+awake);
        br.close();
    }
}