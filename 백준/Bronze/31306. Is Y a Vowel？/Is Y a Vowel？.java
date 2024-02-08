import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int ans1 = 0, ans2 = 0;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c =='o' || c =='u') {
                ans1++;
                ans2++;
            }else if (c=='y') ans2++;
        }
        System.out.print(ans1 + " " + ans2);
        br.close();
    }
}