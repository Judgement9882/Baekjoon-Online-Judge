#include <iostream>
#include <string>
using namespace std;

int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    while(1){
        string temp;
        cin >> temp;
        if(temp == "0") break;
        
        for(int i = 0 ; ; i++){
            if(temp[i] != temp[temp.length()-1-i]) {
                cout << "no\n";
                break;
            }
            if(i == temp.length()/2){
                cout << "yes\n";
                break;
            }
        }
    }
    return 0;
}