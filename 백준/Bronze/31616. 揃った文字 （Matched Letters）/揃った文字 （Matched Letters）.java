import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        char c = temp.charAt(0);
        boolean ans = true;
        for(int i = 1; i < N; i++){
            if(c != temp.charAt(i)) {
                ans = false;
                break;
            }
        }
        sb.append(ans?"Yes":"No");
        System.out.println(sb);
        br.close();
    }
}