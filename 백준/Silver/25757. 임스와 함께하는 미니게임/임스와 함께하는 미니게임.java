import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        for(int i = 0 ;i < N; i++){
            set.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        if(game == 'Y') sb.append(set.size());
        else if(game == 'F') sb.append(set.size()/2);
        else sb.append(set.size()/3);
        System.out.print(sb);
        br.close();
    }

}