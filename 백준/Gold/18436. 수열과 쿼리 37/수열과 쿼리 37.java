import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int odd;
        int even;
        Node(int odd, int even){
            this.odd = odd;
            this.even = even;
        }
    }
    static int arr [];
    static Node segTree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        int tree_size = (1<<(H+1));
        segTree = new Node[tree_size];
        init(1, 0, N-1);

        int M = Integer.parseInt(br.readLine());
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order==1) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                update(1, 0, N-1, i-1, x);
            }
            else{
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, N-1, l-1, r-1, order%2)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static void init(int node, int start, int end){
        // leaf node
        if(start==end) {
//            segTree[node] = arr[start];
            int odd = 0, even = 0;
            if(arr[start] % 2 == 0) even++;
            else                    odd++;
            segTree[node] = new Node(odd, even);
            return;
        }

        init(node*2, start, (start+end)/2);
        init(node*2+1, (start+end)/2 + 1, end);

        int [] ret = calculate(segTree[node*2], segTree[node*2+1]);
        segTree[node] = new Node(ret[0], ret[1]);
    }

    static void update(int node, int start, int end, int index, int val){
        if(index < start || end < index) return;
        // leaf node
        if(start==end){
//            arr[index] += val;
            if(val % 2 == 0)    segTree[node] = new Node(0, 1);
            else                segTree[node] = new Node(1, 0);
            return;
        }

        // find leaf node
        update(node*2, start, (start+end)/2, index, val);
        update(node*2+1, (start+end)/2+1, end, index, val);
        int [] ret = calculate(segTree[node*2], segTree[node*2+1]);
        segTree[node] = new Node(ret[0], ret[1]);
    }

//    static long query(int node, int start, int end, int left, int right){
//        if(right < start || end < left) return 0;
//
//        if(left <= start && end <= right){
//            return segTree[node];
//        }
//
//        long lNode = query(node*2, start, (start+end)/2 , left, right);
//        long rNode = query(node*2+1, (start+end)/2+1, end, left, right);
//        return lNode+rNode;
//    }
    static int query(int node, int start, int end, int left, int right, int order){
        if(right < start || end < left) return 0;

        if(left <= start && end <= right){
            if(order == 0)  return segTree[node].even;
            else            return segTree[node].odd;
        }

        int lNode = query(node*2, start, (start+end)/2 , left, right, order);
        int rNode = query(node*2+1, (start+end)/2+1, end, left, right, order);
        return lNode+rNode;
    }

    static int[] calculate(Node a, Node b){
        int [] ret = new int[2];
        ret[0] = a.odd+b.odd;
        ret[1] = a.even+b.even;
        return ret;
    }
}