#include<iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    vector<string> dud;
    vector<string> bo;

    int N, M; cin >> N >> M;
    int temp_N = N, temp_M = M;
    while (temp_N--) {
        string temp; cin >> temp; dud.push_back(temp);
    }
    while (temp_M--) {
        string temp; cin >> temp; bo.push_back(temp);
    }

    sort(dud.begin(), dud.end());
    sort(bo.begin(), bo.end());

    int it_dud = 0, it_bo = 0;
    int cnt = 0;
    vector<string> ans;
    
    while (1) {
        if (it_dud == N || it_bo == M) break;

        if (dud[it_dud] > bo[it_bo]) {
            if (it_bo != M) {
                it_bo++;
            }
            else {
                it_dud++;
            }
        }
        else if (dud[it_dud] < bo[it_bo]){
            if (it_dud != N) {
                it_dud++;
            }
            else {
                it_bo++;
            }
        }
        else {
            ans.push_back(dud[it_dud]);
            if (it_dud != N) {
                it_dud++;
            }
            if (it_bo != M) {
                it_bo++;
            }
            cnt++;
        }
    }

    cout << cnt << "\n";
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << "\n";
    }

    return 0;
}