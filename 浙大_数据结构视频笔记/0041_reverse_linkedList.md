### src: 来自leetcode 206;

思想: 一直伴随整个程序的是pre和cur两个指针, 每次往后移动; pre初始化为NULL作为整个链表的head要reverse之后指向的NULL; **cur的下一个节点temp是每次循环的过程中获得的🉐️!** 并不是一开始就常伴程序的变量;

下面是代码，实际上很简单: 
```
/**
  Definition of a singly-linked list.
  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 **/
 
 class Solution {
 public:
    ListNode* reverseList(ListNode* head) {
        ListNode *pre = NULL, *cur = head;
        while (cur) {
            ListNode *tmp = cur->next;
            cur->next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre; // pre到达了最后面，对应反转之后的最前面的节点
    }
};
```
