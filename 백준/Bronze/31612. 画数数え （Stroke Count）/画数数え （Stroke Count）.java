import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int ans = 0;
        for(int i = 0; i < N; i++){
            if(str.charAt(i) == 'j') ans += 2;
            else if (str.charAt(i) == 'o') ans++;
            else ans += 2;
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}