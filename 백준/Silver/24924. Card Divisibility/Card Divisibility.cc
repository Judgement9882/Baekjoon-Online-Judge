#include <iostream>

using namespace std;

long long L, R;

int mod9(long long n){
    if (n == 0) return 0;

    int sum = 0;
    long long factor = 1;
    
    while (n / factor > 0) {
        long long high = n / (factor * 10);
        long long current_digit = (n / factor) % 10;
        long long low = n % factor;

        // 상위 자릿수에서 1부터 9까지 반복되는 패턴을 이용해 빠르게 합을 계산
        sum += (high * 45) % 9;  // 0~9의 자리수 합은 45
        sum %= 9;

        // 현재 자릿수의 숫자에 따른 처리
        sum += (current_digit * (current_digit - 1) / 2) % 9;
        sum %= 9;

        // 남은 낮은 자릿수에 대해 처리
        sum += (current_digit * (low + 1)) % 9;
        sum %= 9;

        factor *= 10;
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