#include <iostream>
#include <vector>
using namespace std;
int main() {
    cin.tie(0); ios::sync_with_stdio(0);

    int P; cin >> P;
    while(P--){
        int T; cin >> T;

        int twenty = 20;
        vector<int> arr;
        int num; cin >> num; arr.push_back(num);
        int ans = 0;
        for(int i = 1; i < twenty; i++){
            cin >> num;
            for(auto i : arr){
                if(i > num) ans++;
            }
            arr.push_back(num);
        }
        cout << T << " " << ans << "\n";
    }

    
    return 0;
}