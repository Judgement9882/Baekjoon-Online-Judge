import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean start = false;
        HashSet<String> dance = new HashSet<>();
        for(int i = 0 ;i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if(a.equals("ChongChong") || b.equals("ChongChong")) {
                start = true;
                dance.add(a);
                dance.add(b);
            }
            if(start){
               if(dance.contains(a) || dance.contains(b)){
                   dance.add(a);
                   dance.add(b);
               }
            }
        }
        System.out.print(dance.size());
        br.close();
    }
}