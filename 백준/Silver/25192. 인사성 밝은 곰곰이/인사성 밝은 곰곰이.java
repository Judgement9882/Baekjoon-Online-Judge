import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int ans = 0;
        for(int i = 0 ; i < N; i++){
            String order = br.readLine();
            if(order.equals("ENTER")) set.clear();
            else{
                if(!set.contains(order)){
                    set.add(order);
                    ans++;
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}