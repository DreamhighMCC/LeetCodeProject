package com.dreamhigh.leetcode.List;

public class ListAdd {
    private ListNode addTwoNumbersImpl(int a, ListNode l1, ListNode l2) {
        int tmp;
        if (l1 == null && l2 == null && a <= 0) {
            return null;
        } else if (l1 == null && l2 == null && a > 0) {
            return new ListNode(a);
        } else if (l1 == null || l2 == null) {
            ListNode ll = (l1 == null ? l2 : l1);
            tmp = ll.val + a;
            ListNode res = new ListNode(tmp % 10);
            res.next = addTwoNumbersImpl(tmp / 10, ll.next, null);
            return res;
        } else {
            tmp = l1.val + l2.val + a;
            ListNode res = new ListNode(tmp % 10);
            res.next = addTwoNumbersImpl(tmp / 10, l1.next, l2.next);
            return res;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode res = addTwoNumbersImpl(0, l1, l2);
        return res;
    }
}
