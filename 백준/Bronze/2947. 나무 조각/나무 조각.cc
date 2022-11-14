#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int wood[5];

void printWood() {
    for (int i = 0; i < 5; i++) {
        cout << wood[i] << " ";
    }
    cout << "\n";
    return;
}

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    for (int i = 0; i < 5; i++) {
        cin >> wood[i];
    }
    
    while (1) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            if (wood[i] > wood[i + 1]) {
                cnt++;
                swap(wood[i], wood[i + 1]);
                printWood();
            }
        }
        
        if (!cnt) break;
    }


    return 0;
}