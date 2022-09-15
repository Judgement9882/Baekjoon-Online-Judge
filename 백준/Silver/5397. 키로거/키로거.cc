#include <iostream>
#include <list>
using namespace std;
int main(){
    int T;
    cin>>T;
    while(T--){
        string str;
        cin>>str;
        list<char> l;
        auto cursor = l.end();
        for(int i=0;i<str.size();i++){
            if(str[i]=='<'){
                //커서감소, begin이면 예외처리
                if(cursor!=l.begin()){
                    cursor--;
                }
            }else if(str[i]=='>'){
                //커서증가 end면 예외처리
                if(cursor!=l.end()){
                    cursor++;
                }
            }else if(str[i]=='-'){
                //cursor-1 값 삭제 begin이면 예외처리
                if(cursor != l.begin()){
                    auto tmp = cursor;
                    cursor--;
                    l.erase(cursor);
                    cursor=tmp;
                }
            }else{
                //값 추가
                l.insert(cursor,str[i]);
                //cursor++;
            }
        }
        for(auto it=l.begin();it!=l.end();it++){
            cout<<*it;
        }
        cout<<'\n';
    }
    
    return 0;
}
