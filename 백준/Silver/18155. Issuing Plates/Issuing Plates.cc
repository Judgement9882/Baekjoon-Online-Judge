#include <iostream>
#include <string>

#define MAX_N 101

using namespace std;

int N, M;
string bad_str[MAX_N];
string equivalences = "OLZE4SBTB9";

bool checkWord(string str){
    for(int i = 0 ; i < N; i++){
        string cmpWord = bad_str[i];
        // 더 길이가 짧으면 포함 x
        int inputLen = str.length();
        int cmpLen = cmpWord.length();
        if(cmpLen <= inputLen){
            int k = 0;
            
            while(k + cmpLen <= inputLen){
                bool temp = true;
                for(int j = 0; j < cmpLen; j++){
                    if(cmpWord[j] != str[j+k]) temp = false;
                }   
                if(temp) return false; // 겹침
                else k++;
            }
        }
    }
    return true; // 겹치는게 없음
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N >> M;
    for(int i = 0; i < N; i++){
        cin >> bad_str[i];
    }
    for(int i = 0; i < M; i++){
        string str; cin >> str;
        for(int j = 0; j < str.length(); j++){
            if(str[j] >= '0' && str[j] <= '9'){
                str[j] = equivalences[str[j]-'0'];
            }
        }
    
        cout << (checkWord(str) ? "VALID" : "INVALID") << "\n";
    }
    return 0;
}