#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int N, num, info=0, cnt = 0;
    cin >> N;
    
    
    while(N--){
        cin >> num;
        if (num > 0){
            info++;
            cnt += info;   
        }
        else{
            info = 0;
        }        
    }

    cout << cnt;
    
    return 0;
}