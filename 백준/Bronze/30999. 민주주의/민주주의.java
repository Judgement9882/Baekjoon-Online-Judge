import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        while(N-->0){
            int ok = 0;
            int nok = 0;
            String temp = br.readLine();
            for(int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) == 'O') ok++;
                else nok++;
            }
            if(ok > nok) ans++;
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}