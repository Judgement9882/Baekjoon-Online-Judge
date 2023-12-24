import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken())-1;
            for(int i = 0; i < str.length(); i++){
                if(start <= i && i <= end) continue;
                sb.append(str.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}