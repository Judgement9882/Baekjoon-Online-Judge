#include <iostream>
#include <string>
using namespace std;

int main() {

    // 입출력 속도 관리
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    string str;
    getline(cin, str);

    int cnt = 0;

    int flag = 0;

    for (int i = 0; i < str.size(); i++) {
        if (str[i] > 64) {
            flag = 1;
            continue;
        }
        if (str[i] == ' ' && flag == 1) {
            
            cnt++;
        }
    }

    if (str[str.size()-1] == ' ') {
        cnt--;
    }

    cout << cnt+1;
    
    return 0;
}
