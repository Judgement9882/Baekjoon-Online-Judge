import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "x");
        boolean ans = false;
        while(st.hasMoreTokens()){
            if(st.nextToken().length() >= 3) {
                ans = true;
                break;
            }
        }
        sb.append(ans?"Yes":"No");
        System.out.println(sb);
        br.close();
    }
}