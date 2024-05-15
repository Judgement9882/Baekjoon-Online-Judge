#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    long long Vk, Jk, Vl, Jl, Vh, Dh, Jh;
    cin >> Vk >> Jk >> Vl >> Jl >> Vh >> Dh >> Jh;
    cout << (Vk * Jk + Vl * Jl) * Vh * Dh * Jh;

    return 0;
}