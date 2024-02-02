import java.io.*;
import java.util.*;
public class Main {
    static long arr [];
    static long segTree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new long[N];

//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        // create segment tree
        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        int tree_size = (1<<(H+1));
        segTree = new long[tree_size];
        init(1, 0, N-1);

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order==0) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(x>y){
                    int temp = x;
                    x = y;
                    y = temp;
                }

                sb.append(query(1, 0, N-1, x-1, y-1)).append("\n");
            }
            else{
                int i = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                update(1, 0, N-1, i-1, k);
            }
        }

        System.out.print(sb);
        br.close();
    }

    static void init(int node, int start, int end){
        if(start==end) {
            segTree[node] = arr[start];
        }
        else {
            init(node*2, start, (start+end)/2);
            init(node*2+1, (start+end)/2 + 1, end);
            segTree[node] = segTree[node*2] + segTree[node*2+1];
        }
    }

    static long query(int node, int start, int end, long left, long right){
        // 범위 밖이면 1
        if(right < start || end < left) return 0;

        // 적합한 영역
        if(left <= start && end <= right){
            return segTree[node];
        }

        long lsum = query(node*2, start, (start+end)/2, left, right);
        long rsum = query(node*2+1, (start+end)/2+1, end, left, right);
        return lsum+rsum;
    }

    static void update(int node, int start, int end, int index, long val){
        // index 범위 밖이면 return
        if(index < start || end < index) return;

        // 리프노드라면 index 번째 수를 val로 바꾸고
        // 해당 위치의 segTree의 node도 val로 바꾸고
        if(start==end){
            arr[index] = val;
            segTree[node] = val;
            return;
        }

        // 리프노드가 아니라면 리프노드를 찾으러 내려감
        update(node*2, start, (start+end)/2, index, val);
        update(node*2+1, (start+end)/2+1, end, index, val);

        // 재귀적으로 부모 노드 값 갱신
        segTree[node] = segTree[node*2] + segTree[node*2+1];
    }
}