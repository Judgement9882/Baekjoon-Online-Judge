#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
using namespace std;

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    string temp;
    getline(cin, temp);

    int ha = 0, sa = 0;

    for (int i = 0; i < temp.length(); i++) {
        if (temp[i] == ':') {
            if ((i+1 < temp.length()) && temp[i + 1] == '-') {
                if ((i + 2 < temp.length()) && temp[i + 2] == ')') {
                    ha++;
                }

                else if ((i + 2 < temp.length()) && temp[i + 2] == '(') {
                    sa++;
                }
            }
        }
    }
    if (ha > sa) {
        cout << "happy";
    }
    else if (ha < sa) {
        cout << "sad";
    }
    else if (ha == 0 && sa == 0) {
        cout << "none";
    }
    else if (ha == sa){
        cout << "unsure";
    }
    
    return 0;
}