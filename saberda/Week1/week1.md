## 65-Valid Number

**Link:**

[LeetCode 65](https://leetcode.com/problems/valid-number/)

[Source Code](https://github.com/SaberDa/LeetCode/blob/master/C%2B%2B/65-validNumber.cpp)

**Problem:**



- What's 'e' meaning?

  ​	2e10 = 2 * (10^10)

- How to define a valid number?

  - only number
    - if it has dot, there must be only one dot
  - contains 'e'
    - before 'e', there must be number
    - after 'e', there must be number
    - there must be only one 'e'

**Algorithm:**

```
1. Remove spaces at both ends
2. Judge positive or negative
3. Judge digit
	- current char is digit, next
	- current char is 'e'
		- determine whether it is a number before and after
	- current char is '.'
		- determine whether it is a number before and after
```

**Code:**

```c++
#include <iostream>
#include <string>

using namespace std;

bool isNumber(string s) {
    
    // 1. Judge is empty
    if (s.length() == 0) {
        return false;
    }
    
    // 2. Initial variables
    int i = 0;     					// index
    int n = s.length() - 1;			// valid length
    // we need three bools variables
    bool e = false;					// e
    bool dot = false;				// dot
    bool digit = false;				// digit
    
    // 3. Erase the space ' ' in the given string s
    // both from the begin and end
    while (i < s.length() && s[i] == ' ') {
        i++;
    }
    while (n >= 0 && s[n] == ' ') {
        n--;
    }
    
    // 4. Judge positive or negative
    if (s[i] == '+' || s[i] == '-') {
        i++;
    }
    
    // 5. Before judge number, we need to judge the string validly again
    if (i > n) {
        return false;
    }
    
    // 6. Judge number
    for (; i <= n; i++) {
        // judge whether the current char is a number
        if (isdigit(s[i])) {
            // is yes, continue the loop
            digit = true;
            continue;
        } else if (s[i] == 'e' && digit && i != n && !e) {
            // judge e
            e = true;
            // judge exponent, we can have negative exponent
            if (s[i+1] == '+' || s[i+1] == '-') {
                if (i+1 == n) {
                    // there must be number after the '-' or '+'
                    return false;
                } else {
                    i++;
                }
            }
        } else if (s[i] == '.' && !dot && !e) {
            // just dot
            dot = true;
        } else {
            return false;
        }
    }
    return digit;
}

int main() {
    cout << isNumber("2e10") << endl;
    return 0;
}
```



---



## 29-Divide Two Integers

**Link:**

[LeetCode 29](https://leetcode.com/problems/divide-two-integers/)

[Source Code](https://github.com/SaberDa/LeetCode/blob/master/C%2B%2B/29-divideTwoIntegers.cpp)

**Problem:**



- We cannot use multiplication, division and mod operator.
  - use bit shifting
    - \>> 1 means %2
    - \<< 1 means *2
      - 1 \<< bit means 2^bit
- The divisor will never be 0
- Can only store 32-bit, -> cannot use 'long'

**Algorithm:**

```
1. Judging special cases
2. Determine whether both the divisor and the dividend are legal
3. Use bit shift get the quotient
```

[GIF](https://leetcode.com/problems/divide-two-integers/solution/)

Code:**

```c++
#include <iostream>
#include <climits>
#include <cmath>

using namespace std;

int divide(int dividend, int divisor) {
    // A cheat: The INT_MIN is -2147483648. If the dividend is INT_MIN, we add 1 to it.
    // Because the INT_MAX is +2147483647.
    // When do the abs, the INT_MIN will overflow.
    int boost = 0;
    
    // 1. Judging special cases
    if (dividend == INT_MIN) {
        if (divisor == -1) {
            return INT_MAX;
        } else if (divisor == 1) {
            return INT_MIN;
        } else {
            dividend++;
            boost = 1;
        }
    }
    if (divisor == INT_MIN) {
        if (dividend == INT_MAX) {
            return 0;
        } else {
            divisor++;
        }
    }

    // 2. Determine whether both the divisor and the dividend are legal
    if (dividend < 0 && dividend > divisor) {
        return 0;
    }
    if (dividend > 0 && dividend < divisor) {
        return 0;
    }

    // you should use unsigned int or you will overfolw with 2147483647
    unsigned int absDividend = abs(dividend);
    unsigned int absDivisor = abs(divisor);
    int quotient = 0;

    // 3. Use bit shift get the quotient
    while (static_cast<int>(absDividend) >= static_cast<int>(absDivisor)) {
        int bit = 0;
        while (bit <= 29 && (absDividend + boost >= (absDivisor << (bit + 1)))) {
            bit++;
        }

        quotient += (1 << bit);
        absDividend -= (absDivisor << bit);
    }

    if ((dividend > 0) == (divisor > 0)) {
        return quotient;
    } else {
        return quotient * -1;
    }
}

int main() {
    cout << divide(-1, -1) << endl;
    return 0;
}
```

---

## 249-Group Shifted Strings

*This a member's problem.*

**Link:**

[LeetCode 249](https://leetcode.com/problems/group-shifted-strings/)

[Source Code](https://github.com/SaberDa/LeetCode/blob/master/C%2B%2B/249-groupShiftedStrings.cpp)

**Problem:**



**Algorithm:**

```
Main Point:
	We use one to represent all 
	for example: "abc", "bcd", "xyz" have the same "shifting", so we use "abc" to represent all of them. In other word, we use the "abc" as the key, and all matches are value.
```

**Code:**

```c++
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<vector<string>> groupStrings(vector<string>& strings) {
    vector<vector<string>> res;
    unordered_map<string, vector<string>> mp;

    // put the "value" strings into "key" string
    for (auto& s: strings) {
        mp[shift(s)].push_back(s);
    }

    for (auto& v : mp) {
        sort(v.second.begin(), v.second.end());
        res.push_back(v.second);
    }
    
    return res;
}

string shift(string s) {
    // Calculate the ket of string s
    if (s.size() <= 1) {
        return "a";
    }
    int diff = s[0] - 'a';
    string res;
    for (auto c : s) {
        if (c - diff < 'a') {
            c += (26 - diff);
        } else {
            c -= diff;
        }
        res.push_back(c);
    }
    return res;
}

int main() {

    vector<string> strings;
    strings.push_back("abc");
    strings.push_back("bcd");
    strings.push_back("acef");
    strings.push_back("xyz");
    strings.push_back("az");
    strings.push_back("ba");
    strings.push_back("a");
    strings.push_back("z");

    cout << shift(strings[0]) << endl;
    return 0;
}
```

