#include <iostream>

using namespace std;

int main(){
    
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N, vote, res=0;
    cin >> N;
    while(N--){
        cin >> vote;
        if (vote == 0) res--;
        else res++;
    }
    if (res > 0) cout << "Junhee is cute!";
    else cout << "Junhee is not cute!";
    return 0;
}