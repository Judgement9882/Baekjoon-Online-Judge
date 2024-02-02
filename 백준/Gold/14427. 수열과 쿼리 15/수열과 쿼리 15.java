import java.io.*;
import java.util.*;
public class Main {

    static class Type{
        long val;
        int idx;
        Type(long val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    static long arr [];
    static Type segTree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        int tree_size = (1<<(H+1));
        segTree = new Type[tree_size];
        init(1, 0, N-1);

        int M = Integer.parseInt(br.readLine());
        while(M-->0){
//            System.out.println("segTree : \n");
//            for(int i = 1; i < segTree.length; i++){
//                if(segTree[i] != null) System.out.println("index : " + i + " val : " + segTree[i].val + " idx : " + segTree[i].idx);
//            }
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order==2) sb.append(segTree[1].idx).append("\n");
            else{
                int i = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken());
                update(1, 0, N-1, i-1, v);
            }
        }

        System.out.print(sb);
        br.close();
    }

    static void init(int node, int start, int end){
        if(start==end) {
            segTree[node] = new Type(arr[start], start+1);
//            System.out.println("node : " + node + " val : " + segTree[node].val + " idx : " + segTree[node].idx);
        }
        else {
            init(node*2, start, (start+end)/2);
            init(node*2+1, (start+end)/2 + 1, end);
            updateMinIndex(node);
        }
    }

    static void update(int node, int start, int end, int index, long val){
        if(index < start || end < index) return;
        // leaf node
        if(start==end){
            arr[index] = val;
            segTree[node] = new Type(val, start+1);
            return;
        }

        // find leaf node
        update(node*2, start, (start+end)/2, index, val);
        update(node*2+1, (start+end)/2+1, end, index, val);
        updateMinIndex(node);
    }

    static void updateMinIndex(int node){
        if(segTree[node*2].val == segTree[node*2+1].val){
            segTree[node] = new Type(segTree[node*2].val, Math.min(segTree[node*2].idx, segTree[node*2+1].idx));
        }
        else if(segTree[node*2].val > segTree[node*2+1].val){
            segTree[node] = new Type(segTree[node*2+1].val, segTree[node*2+1].idx);
        }
        else{
            segTree[node] = new Type(segTree[node*2].val, segTree[node*2].idx);
        }
    }
}