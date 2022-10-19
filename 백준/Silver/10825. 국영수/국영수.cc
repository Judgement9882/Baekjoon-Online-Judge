/*
    https://www.acmicpc.net/problem/10825

    국영수
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct STUDENT {
    string name;
    int korean;
    int english;
    int math;
};

bool compare(STUDENT a, STUDENT b) {
    if (b.korean < a.korean) {
        return true;
    }
    else if (a.korean == b.korean) {
        if (a.english < b.english) {
            return true;
        }

        else if (a.english == b.english) {
            if (b.math < a.math) {
                return true;
            }

            else if (a.math == b.math){
                if (a.name < b.name) {
                    return true;
                }
            }
        }
    }

    return false;
}

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N; cin >> N;
    vector<STUDENT> st;
    for (int i = 0; i < N; i++) {
        string name;
        int korean;
        int english;
        int math;
        cin >> name >> korean >> english >> math;
        st.push_back({ name, korean, english, math });
    }
    
    sort(st.begin(), st.end(), compare);

    for (int i = 0; i < N; i++) {
        cout << st[i].name << "\n";
    }

    return 0;
}
