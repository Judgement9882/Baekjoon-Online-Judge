import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char alphabet[] = new char[26];
        String str = br.readLine();
        for(int i = 0 ; i < N; i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                alphabet[str.charAt(i)-'a']++;
            }
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) ans = Math.max(ans, alphabet[i]);
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}