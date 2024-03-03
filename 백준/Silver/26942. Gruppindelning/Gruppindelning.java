import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> []name = new ArrayList[N];
        for(int i = 0; i < N; i++){
            map.put(br.readLine(), i);
            name[i] = new ArrayList<>();
        }
        boolean[] vis = new boolean[N];
        int M = Integer.parseInt(br.readLine());
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            name[map.get(a)].add(b);
            name[map.get(b)].add(a);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        // 체크
        int ans = 0;
        for(int i = 0; i < N; i++){
            if(!vis[i]){
                q.offer(i);
                vis[i] = true;
                ans++;
                // 연결된 친구 확인
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(String temp : name[cur]) {
                        if(!vis[map.get(temp)]) {
                            q.offer(map.get(temp));
                            vis[map.get(temp)] = true;
                        }
                    }
                }
            }
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}