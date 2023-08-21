import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i < N; i++){
            String temp = st.nextToken();
            arr.add(temp);
            map.put(temp, 0);
        }
        for(int i = 0 ; i < N; i++){
            String like[] = br.readLine().split(" ");
            for(String a : like){
                map.put(a, map.get(a)+1);
//                System.out.println(a);
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Pop> ans = new ArrayList<>();
        for(String a : arr){
            ans.add(new Pop(map.get(a), a));
        }
        Collections.sort(ans, (o1, o2)->{
            int r = -Integer.compare(o1.pop, o2.pop);
            if(r==0) return o1.name.compareTo(o2.name);
            return r;
        });
        for(Pop p : ans){
            sb.append(p.name).append(" ").append(p.pop).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static class Pop{
        int pop;
        String name;
        Pop(int pop, String name){
            this.pop = pop;
            this.name = name;
        }
    }
}