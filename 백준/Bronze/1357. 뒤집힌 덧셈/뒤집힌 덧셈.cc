#include<iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int A, B; 
int rev(int x) {
    // 한자리 수라면
    if (x < 10) return x;
    
    // 두자리 수
    if (x < 100) {
        int temp = 0;
        temp += (x % 10)*10;
        x /= 10;
        temp += x;
        return temp;
    }

    // 세자리 수
    if (x < 1000) {
        int temp = 0;
        temp += (x % 10) * 100;
        x /= 10;
        temp += (x % 10) * 10;
        x /= 10;
        temp += x;
        return temp;
    }

    // 네자리 수
    else{
        int temp = 0;
        temp += (x % 10) * 1000;
        x /= 10;
        temp += (x % 10) * 100;
        x /= 10;
        temp += (x % 10) * 10;
        x /= 10;
        temp += x;
        return temp;
    }

}

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> A >> B;
    
    cout << rev(rev(A) + rev(B));
    
    return 0;
}