import java.io.*;
import java.util.*;
public class Main {
    static long [] arr, segTree;
    static boolean[] lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new long[N];
//        for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        // height
        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        int tree_size = (1<<(H+1));
        segTree = new long[tree_size];
        lazy    = new boolean[tree_size];
//        init(1, 0, N-1);

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(b>c) {
                int temp = b;
                b = c;
                c = temp;
            }
            if(a==0) update_range(1, 0, N-1, b-1, c-1);
            else sb.append(query(1, 0, N-1, b-1, c-1)).append("\n");

//            System.out.println("segTree test");
//            for(int i = 1; i < tree_size; i++){
//                System.out.println(i + " 번째 : " +  segTree[i] + " ");
//            }
//            System.out.println("========================");
//
//            System.out.println("lazy test");
//            for(int i = 1; i < tree_size; i++){
//                System.out.println(i + " 번째 : " +  lazy[i] + " ");
//            }
//            System.out.println("========================");
        }
        System.out.print(sb);
        br.close();
    }

//    static void init(int node, int start, int end){
//        if(start==end){
//            segTree[node] = arr[start];
//            return;
//        }
//
//        init(node*2, start, (start+end)/2);
//        init(node*2+1, (start+end)/2+1, end);
//        segTree[node] = segTree[node*2] + segTree[node*2+1];
//    }

    static void update_lazy(int node, int start, int end){
//        System.out.println("lazy 불림 !! node : " + node);

        // 0이 아니면 해당 노드는 lazy[i]가 있음. 구간만큼 더해줘야함
        if(lazy[node]){
            segTree[node] = end-start+1 - segTree[node];

            // 만약 리프노드가 아니라면
            if(start!=end){
                // 자식 노드에 lazy 갱신
                lazy[node*2] ^= true;
                lazy[node*2+1] ^= true;
            }

            // 현재 노드 레이지 초기화
            lazy[node] = false;
        }
    }

    static void update_range(int node, int start, int end, int left, int right){
        update_lazy(node, start, end);
        if(right < start || end < left) return;
        if(left <= start && end <= right){
            // 구간 안이라면 구간*val 만큼 더함
            segTree[node] = end-start+1 - segTree[node];

            // 리프노드가 아니라면 lazy[i]를 더해서 나중에 계산
            if(start != end){
                lazy[node*2] ^= true;
                lazy[node*2+1] ^= true;
            }
            return;
        }

        update_range(node*2, start, (start+end)/2, left, right);
        update_range(node*2+1, (start+end)/2+1, end, left, right);
        segTree[node] = segTree[node*2]+segTree[node*2+1];
    }

    static long query(int node, int start, int end, int left, int right){
        update_lazy(node, start, end);
        if(right < start || end < left) return 0;
        if(left <= start && end <= right) return segTree[node];

        long lsum = query(node*2, start, (start+end)/2, left, right);
        long rsum = query(node*2+1, (start+end)/2+1, end, left, right);
        return lsum+rsum;
    }
}