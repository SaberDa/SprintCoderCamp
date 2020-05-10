# Array

## Three Sum

时间复杂度 O(N^2)

最先想的方法是找出a,b；然后找出C。连写两个for循环后就卡在查重上了。后根据Discussion里给出的方法，发现只要换个思路，先给出a，然后找b,c更可行。但这题取巧的方法是先排序，然后通过low和high两个指针依次找出b,c。同时在修改low和high指针时要跳过相同的元素。low和high指针的方法同样出现在11题（Container With Most Water），可惜没想到排序，就更不可能会联想到用这种方法。

# 3Sum Closest

时间复杂度 O(N^2)

根据Three Sum稍加修改**Three Sum**的代码就可Accept。