import java.io.*;
import java.util.*;
public class Main {
static int ans, meso, K;
    static B_info Boss [];
    static boolean [] isSelected;
    static class B_info{
        long P; // 체력
        int Q; // 메소
        B_info(long P, int Q){
            this.P = P;
            this.Q = Q;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Long> damage = new ArrayList<>(); // 캐릭터당 dps
        for(int i = 0 ; i < N; i++){
            damage.add(Long.parseLong(br.readLine()));
        }
        // M개를 뽑기위해 역순으로 정렬
        Collections.sort(damage, Collections.reverseOrder());

        Boss = new B_info[K];
        isSelected = new boolean[K];
        for(int i = 0 ; i < K; i++){
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            Boss[i] = new B_info(p, q);
        }
        ans = 0;

        // 백트래킹
        for(int i = 0; i < M; i++){
            long dps = damage.get(i)*60*15;
            meso = 0;
            func(0, 0, 0, dps);
            ans += meso;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        System.out.print(sb);
        br.close();
    }

    // n : 선택한 개수, acc : 누적 체력 , cal : 누적 메소
    static void func(int n, long acc, int cal, long dps){
        // 백트래킹
        // 누적 체력이 dps 이상일경우 잡지 못함
        if(acc > dps) return;

        // K개 다 처리 했으면
        if(n == K){
            meso = Math.max(meso, cal);
            return;
        }
        for(int i = n; i < K; i++){
            isSelected[i] = true;
            // 더하는 양
            long cal_p = 0;
            if(Boss[i].P % (dps/900) == 0){
                // 나누어 떨어지면 그만큼 더하면됨
                cal_p = Boss[i].P;
            }else{
                // 나누어 떨어지지 않으면 +1해서 더해야함
                cal_p = ((Boss[i].P / (dps/900))+1)*(dps/900);
            }
//            acc += Boss[i].P;
            acc += cal_p;
            cal += Boss[i].Q;
            func(i+1, acc, cal, dps);
            isSelected[i] = false;
//            acc -= Boss[i].P;
            acc -= cal_p;
            cal -= Boss[i].Q;
            func(i+1, acc, cal, dps);
        }
    }

}
