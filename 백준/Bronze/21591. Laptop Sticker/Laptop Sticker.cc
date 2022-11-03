#include<iostream>
#include <algorithm>
#include <vector>
using namespace std;
int A, B, C, D;
bool ans() {
    return (A - C >= 2) && (B - D >= 2);
}
int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> A >> B >> C >> D;
    cout << ans();
    return 0;
}