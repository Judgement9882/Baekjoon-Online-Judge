import java.io.*;
import java.util.*;
public class Main {
    static class Score{
        int nation;
        int number;
        int score;
        Score(int nation, int number, int score){
            this.nation = nation;
            this.number = number;
            this.score = score;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Score> pq = new PriorityQueue<>((o1, o2)->{
            return -Integer.compare(o1.score, o2.score);
        });
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            pq.offer(new Score(nation, number, score));
        }

        int nations[] = new int[101];
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(!pq.isEmpty()){
            Score cur = pq.poll();
            if(nations[cur.nation] >= 2) continue;
            nations[cur.nation]++;
            sb.append(cur.nation + " " + cur.number + "\n");
            cnt++;
            if(cnt >= 3) break;
        }
        System.out.print(sb);
        br.close();
    }
}