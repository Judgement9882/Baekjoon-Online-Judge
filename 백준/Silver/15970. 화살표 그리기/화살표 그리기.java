import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[N+1];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i <= N; i++) list[i] = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[y].add(x);
            set.add(y);
        }
        int ans = 0;
        for(int temp: set){
            Collections.sort(list[temp]);
            for(int i = 0 ; i < list[temp].size(); i++){

                if(i==0){
                    ans += list[temp].get(i+1) - list[temp].get(i);
                } else if (i == list[temp].size()-1){
                    ans += list[temp].get(i) - list[temp].get(i-1);
                } else{
                    ans += Math.min(list[temp].get(i+1) - list[temp].get(i), list[temp].get(i) - list[temp].get(i-1));
                }
            }
        }

        System.out.println(ans);

        br.close();
    }
}