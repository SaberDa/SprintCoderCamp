# You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

# You may assume the two numbers do not contain any leading zero, except the number 0 itself.

# Example:

# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8
# Explanation: 342 + 465 = 807.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        l = l3 = ListNode(0)
        while l1 or l2:
            a = l1.val if l1 else 0
            b = l2.val if l2 else 0  
            sum = a +b + carry
            l3.next = ListNode(sum % 10)
            carry = sum // 10
            if l1: l1 = l1.next
            if l2: l2 = l2.next
            l3 = l3.next
        if carry:
            l3.next = ListNode(carry)
        return l.next