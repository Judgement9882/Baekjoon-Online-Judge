#include <iostream>
#include <queue>
using namespace std;
int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    int N; cin >> N;
    priority_queue<int> pq;
    for(int i = 0; i < N; i++) {
        int num; cin >> num;
        pq.push(num);
    }
    int ans = 0;
    while(pq.size() >= 2){
        int first = pq.top(); pq.pop();
        int second = pq.top(); pq.pop();
        first--; second--;
        if(first != 0) pq.push(first);
        if(second != 0) pq.push(second);
        ans++;
    }
    if(!pq.empty()) ans += pq.top();
    if(ans > 1440) cout << -1;
    else cout << ans;
    return 0;
}