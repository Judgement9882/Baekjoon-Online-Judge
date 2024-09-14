#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    vector<int> arr;
    while(true){
        while(!arr.empty()) arr.pop_back();
        
        int N; cin >> N;
        if(N==0) break;

        for(int i = 0; i < N; i++) {
            int temp; cin >> temp;
            arr.push_back(temp);
        }

        int num = arr[0] + arr[1] + arr[2];
        int ans = num;
        for(int i = 3; i < N; i++){
            num -= arr[i-3];
            num += arr[i];
            ans = max(ans, num);
        }

        cout << ans << "\n";
        
    }
    
    return 0;
}