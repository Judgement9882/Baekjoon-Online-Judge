#include <iostream>
using namespace std;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int T; cin >> T;
    for(int tc = 1; tc <= T; tc++){
        int N; cin >> N;
        int ans = 0;
        string str; cin >> str;
        int laugh = (str[0] - '0');
        for(int i = 1; i <= N; i++){
            if(i > laugh){
                ans += i-laugh;
                laugh += i - laugh;
            }
            laugh += (str[i] - '0');
        }
        
        cout << "Case #" << tc << ": " << ans << "\n";
    }
    
    return 0;
}