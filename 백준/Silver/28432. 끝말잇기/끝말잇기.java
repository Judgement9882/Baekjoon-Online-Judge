import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> words = new HashSet<>();
        String word[] = new String[N];
        int index = 0;
        for(int i = 0 ;i < N; i++){
            word[i] = br.readLine();
            words.add(word[i]);
            if(word[i].equals("?")) index = i;
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M; i++){
            String temp = br.readLine();
            if(words.contains(temp)) continue;
            if(index != 0 && word[index-1].charAt(word[index-1].length()-1) != temp.charAt(0)) continue;
            if(index != N-1 && word[index+1].charAt(0) != temp.charAt(temp.length()-1)) continue;
            sb.append(temp);
        }

        System.out.println(sb);
        br.close();
    }

}