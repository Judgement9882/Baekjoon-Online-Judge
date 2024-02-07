import java.io.*;
import java.util.*;
public class Main {
    static long [] arr, segTree, lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        // height
        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        int tree_size = (1<<(H+1));
        segTree = new long[tree_size];
        lazy    = new long[tree_size];
        init(1, 0, N-1);

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==1){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if(b>c) {
                    int temp = b;
                    b = c;
                    c = temp;
                }
                long d = Long.parseLong(st.nextToken());
                update_range(1, 0, N-1, b, c, d);
            }
            else{
                int b = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, N-1, b, b)).append("\n");
            }
//            System.out.print("segTree : ");
//            for(int i = 1 ; i < tree_size; i++){
//                System.out.print(segTree[i] + " ");
//            }
//            System.out.println();
//            System.out.print("lazy : ");
//            for(int i = 1 ; i < tree_size; i++){
//                System.out.print(lazy[i] + " ");
//            }
//            System.out.println();
        }
        System.out.print(sb);
        br.close();
    }

    static void init(int node, int start, int end){
        if(start==end){
            segTree[node] = arr[start];
            return;
        }

        init(node*2, start, (start+end)/2);
        init(node*2+1, (start+end)/2+1, end);
        segTree[node] = segTree[node*2] ^ segTree[node*2+1];
    }

    static void update_lazy(int node, int start, int end){

//        System.out.println("이 노드를 방문했어요 : " + node);
        // 0이 아니면 해당 노드는 lazy[i]가 있음. 구간만큼 더해줘야함
        if(lazy[node] != 0){
            if((end-start+1)%2!=0){
                segTree[node] ^= lazy[node];
            }
//            segTree[node] += (end - start + 1) * lazy[node];

            // 만약 리프노드가 아니라면
            if (start != end) {
                // 자식 노드에 lazy 갱신
                lazy[node * 2] ^= lazy[node];
                lazy[node * 2 + 1] ^= lazy[node];
            }

            // 현재 노드 레이지 초기화
            lazy[node] = 0;
        }
    }

    static void update_range(int node, int start, int end, int left, int right, long val){
        update_lazy(node, start, end);
        if(right < start || end < left) return;
        if(left <= start && end <= right){
            if((end-start+1)%2!=0){
                segTree[node] ^= val;
            }

            // 리프노드가 아니라면 lazy[i]를 더해서 나중에 계산
            if(start != end){
                lazy[node*2] ^= val;
                lazy[node*2+1] ^= val;
            }
            return;
        }

        update_range(node*2, start, (start+end)/2, left, right, val);
        update_range(node*2+1, (start+end)/2+1, end, left, right, val);
        segTree[node] = segTree[node*2]^segTree[node*2+1];
    }

    static long query(int node, int start, int end, int left, int right){
        update_lazy(node, start, end);
        if(right < start || end < left) return 0;
        if(left <= start && end <= right) return segTree[node];

        long lxor = query(node*2, start, (start+end)/2, left, right);
        long rxor = query(node*2+1, (start+end)/2+1, end, left, right);
        return lxor^rxor;
    }
}