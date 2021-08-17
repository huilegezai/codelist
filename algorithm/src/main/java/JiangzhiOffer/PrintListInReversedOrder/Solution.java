package JiangzhiOffer.PrintListInReversedOrder;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    /**
     * 从尾到头打印链表
     * 1、遍历链表，把元素push到堆栈中
     * 2、遍历pop出元素
     * @param listNode 链表头节点
     * @return list
     */
    private static ArrayList<Integer> solution(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (listNode == null) {
            return res;
        }
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * 递归
     * 若不是链表尾结点，继续递归；
     * 若是，添加到 list 中。
     * @param listNode
     * @return
     */
    private static ArrayList<Integer> solution2(ListNode listNode){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (listNode == null) {
            return res;
        }
        addElement(listNode,res);
        return res;
    }
    private static void addElement(ListNode listNode,ArrayList<Integer> res){
        if (listNode.next != null){
            addElement(listNode.next,res);
        }
        res.add(listNode.val);
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(222);
        ListNode listNode1 = new ListNode(333);
        ListNode listNode2 = new ListNode(444);
        ListNode listNode3 = new ListNode(555);
        ListNode listNode4 = new ListNode(666);
        listNode.next = listNode1;
        listNode.next.next = listNode2;
        listNode.next.next.next = listNode3;
        listNode.next.next.next.next = listNode4;
        System.out.println(solution(listNode));
        System.out.println(solution2(listNode));
    }
}
