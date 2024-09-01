#include <iostream>

using namespace std;

class Node {
public:
	Node* childs[10] = { NULL };
	bool fin = false;
	Node() {}
};
	
class Trie {
public:
	Node* root;
	Trie() { this->root = new Node(); }
	
	void insert(string str) {
		Node* cur = this->root;
		for (int i = 0; i < str.length(); i++) {
			int idx = str[i] - '0';
			if (cur->childs[idx] != NULL)
				cur = cur->childs[idx];
			else {
				cur->childs[idx] = new Node();
				cur = cur->childs[idx];
			}
		}

		cur->fin = true;
	}

	bool find(string str) {
		Node* cur = this->root;
		for (int i = 0; i < str.length(); i++) {
			int idx = str[i] - '0';
			if (cur->childs[idx] == NULL) return 0;
			else cur = cur->childs[idx];
		}

		if (cur->fin) return 1;
		return 0;
	}

	bool check(string str) {
		Node* cur = this->root;
		for (int i = 0; i < str.length(); i++) {
			int idx = str[i] - '0';
			if (cur->childs[idx] == NULL || cur->fin) return false;
			else cur = cur->childs[idx];
		}

		if (cur->fin) return true;
		return false;
	}
};

string str[10005];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int t; cin >> t;
	while (t--) {
		Trie* trie = new Trie();

		int N; cin >> N;
		
		for (int i = 0; i < N; i++) {
			cin >> str[i];
			trie->insert(str[i]);
		}

		bool ans = true;
		for (int i = 0; i < N; i++) {
			if (ans && !(trie->check(str[i]))) ans = false;
		}
		if (ans) cout << "YES\n";
		else cout << "NO\n";
		delete(trie);
	}
	return 0;
}