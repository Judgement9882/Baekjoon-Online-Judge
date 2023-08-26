import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int ans = 0;
        while(N-->0){
            String temp = br.readLine();
            // 포함이 안되어있으면 temp 비롯해서 사이클 단어 set 에 넣기
            if(!set.contains(temp)){
                ans++;
                set.add(temp);
//                System.out.println("add : "+temp);
                for(int i = 1; i < temp.length(); i++){
                    StringBuilder sb= new StringBuilder();
                    sb.append(temp.substring(i, temp.length())).append(temp.substring(0, i));
                    set.add(sb.toString());
//                    System.out.println("add : "+sb.toString());
                }
            }
        }
        System.out.print(ans);

        br.close();
    }
}