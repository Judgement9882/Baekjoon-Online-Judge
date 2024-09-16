#include <iostream>

using namespace std;

long long L, R;

int mod9(long long n){
    if(n==0) return 0;
    int sum = 0;
    for(long long i = 1; i <= n; i*=10){
        long long high = n / (i*10);
        long long current_digit = (n/i) % 10;
        long long low = n%i;

        sum += (high * 45 * (i%9))%9;

        sum += ((current_digit * (current_digit - 1) / 2) * (i % 9))%9;
        sum += (current_digit * ((low + 1) % 9))%9;
    }
    return sum % 9;
}

int modNum(){
    return (mod9(R) - mod9(L-1) + 9) % 9;
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> L >> R;
    cout << modNum();
    return 0;
}