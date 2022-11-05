#include<iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    string temp; cin >> temp;
    cout << temp[0];
    for (int i = 1; i < temp.length(); i++) {
        if (temp[i] == '-') cout << temp[i + 1];
    }

    
    return 0;
}