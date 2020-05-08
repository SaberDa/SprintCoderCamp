#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <ctime>
#include <algorithm>

using namespace std;

#define randomOne(range)(rand()%range)

int main() {

    vector<string> name;
    name.push_back("Arcueid");
    name.push_back("Somewhere warm");
    name.push_back("Peter");
    name.push_back("Umbrella");
    name.push_back("c us rise");
    name.push_back("FIREFIGHTER");
    name.push_back("万世皆虚唯梦是真");
    name.push_back("Roy要joy");

    sort(name.begin(), name.end());

    int count = name.size();
    int index = 1;
    srand((unsigned)time(nullptr));

    while (count) {
        int next = randomOne(count--);
        cout << index++ << ": "<< name[next] << endl;
        name.erase(name.begin() + next);
    }

    return 0;
}