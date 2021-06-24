package leetcode;

import JiangzhiOffer.PrintListInReversedOrder.ListNode;

/**
 * 图解算法数据结构leetBook
 */
public class Solution2 {
    /**
     * 冒泡排序
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null){
            return null;
        }
        int length =0;
        ListNode curr = head;
        while (curr != null){
            length += 1;
            curr = curr.next;
        }
        int[] res = new int[length];
        int j = length-1;
        while (head!=null){
            res[j] = head.val;
            head = head.next;
            j--;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,7,2,3,6,5,4,9,8};
        for (int i=0;i< bubbleSort(a).length;i++){
            System.out.print(bubbleSort(a)[i]);
        }
        System.out.println();
        System.out.println(replaceSpace("  kksl lslsls llslssl ssss   "));

        ListNode listNode = new ListNode(11);
        ListNode listNode1 = new ListNode(22);
        ListNode listNode2 = new ListNode(33);
        ListNode listNode3 = new ListNode(44);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        int[] res = reversePrint(listNode);
        for (int i=0;i<res.length;i++){
            System.out.print(res[i]);
        }
        System.out.println();
    }
}
