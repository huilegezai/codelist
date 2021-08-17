package leetcode;

import JiangzhiOffer.PrintListInReversedOrder.ListNode;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5d3i87/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CQueue {
    private int count;
    private ListNode head;
    private ListNode tail;
    public CQueue() {
        count = 0;
    }

    public void appendTail(int value) {
        ListNode node = new ListNode(value);
        if (head == null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = tail.next;
        }
        count++;
    }

    public int deleteHead() {
        if (head == null || count == 0){
            return -1;
        }else {
            int val = head.val;
            head = head.next;
            count--;
            return val;
        }
    }
}
