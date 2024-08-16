#include <iostream>
#include <unordered_set>
using namespace std;
unordered_set<string> nations;

int calc(string nation, string prev) {
	if (nation == "botswana" || nation == "south-africa") return 0;
	else if (nation == "zambia" && prev == "zimbabwe") return 20;
	else if (nation == "zimbabwe") {
		if (prev == "zambia") return 0;
		return 30;
	}
	else if (nation == "namibia") {
		if (nations.find("south-africa") != nations.end()) return 40;
		else return 140;
	}
	return 50;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n; cin >> n;
	int fee = 0;
	string prev = "";
	for(int i = 0 ; i < n; i++){
		string nation; cin >> nation;
		nations.insert(nation);
		fee += calc(nation, prev);
		prev = nation;
		//cout << nation << " " << fee << "\n";
	}

	cout << fee;
	return 0;
}