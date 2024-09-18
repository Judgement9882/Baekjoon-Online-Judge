#include <iostream>
using namespace std;
int main() {
    cin.tie(0); ios::sync_with_stdio(0);
    int N; cin >> N;
    int M = 0, J = 0, num;
    long long M_num = 0, J_num = 0;
    char who; 
    while(N--){
        cin >> who >> num;
        if(who == 'M'){
            M++;
            M_num += num;
        }else{
            J++;
            J_num += num;
        }
    }

    double M_avg = 0.0, J_avg = 0.0;
    if(M != 0) M_avg = (double)M_num / M;
    if(J != 0) J_avg = (double)J_num / J;
    if(M_avg > J_avg) cout << "M";
    else if (M_avg < J_avg) cout << "J";
    else cout << "V";
    
    return 0;
}