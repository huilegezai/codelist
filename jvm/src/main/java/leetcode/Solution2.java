package leetcode;

import JiangzhiOffer.PrintListInReversedOrder.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 图解算法数据结构leetBook
 */
public class Solution2 {
    /**
     * 冒泡排序
     *
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
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length += 1;
            curr = curr.next;
        }
        int[] res = new int[length];
        int j = length - 1;
        while (head != null) {
            res[j] = head.val;
            head = head.next;
            j--;
        }
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9p0yy1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        /**
         * 利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，再遍历构建新链表各节点的 next 和 random 引用指向即可。
         *
         * 算法流程：
         * 若头节点 head 为空节点，直接返回 null ；
         * 初始化： 哈希表 dic ， 节点 cur 指向头节点；
         * 复制链表：
         * 建立新节点，并向 dic 添加键值对 (原 cur 节点, 新 cur 节点） ；
         * cur 遍历至原链表下一节点；
         * 构建新链表的引用指向：
         * 构建新节点的 next 和 random 引用指向；
         * cur 遍历至原链表下一节点；
         * 返回值： 新链表的头节点 dic[cur] ；
         *
         * 作者：Krahets
         * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9plk45/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/589fz2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
//        String s1 = s.substring(n,s.length());
//        String s2 = s.substring(0,n);
//        return s1 + s2;
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();

    }

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int max = nums[0];
        for (int i = 1; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        res[0] = max;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else {
                if (nums[i - k] == max) {
                    max = nums[i - k + 1];
                    for (int j = i - k + 2; j <= i; j++) {
                        if (nums[j] > max) {
                            max = nums[j];
                        }
                    }
                }
            }
            res[i - k + 1] = max;
        }
        return res;
    }

    /**
     * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
     * <p>
     * <p>
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * <p>
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * <p>
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * <p>
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * <p>
     * 说明：
     * <p>
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。如果数值超过这个范围，请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。
     * <p>
     * 示例1:
     * <p>
     * 输入: "42"
     * 输出: 42
     * 示例2:
     * <p>
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例3:
     * <p>
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例4:
     * <p>
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * 示例5:
     * <p>
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     * 因此返回 INT_MIN (−231) 。
     * <p>
     * <p>
     * 注意：本题与主站 8 题相同：https://leetcode-cn.com/problems/string-to-integer-atoi/
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58pq8g/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param str
     * @return
     */
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') {
                break;
            }
            if (res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0, F(1)= 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：n = 5
     * 输出：5
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50fxu1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        /* 递归，超时
        if (n==0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
         */
        /* 需要额外数组
        if (n==0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for (int i=2;i<=n;i++){
            res[i] = (res[i-1] + res[i-2])%1000000007;
        }
        return res[n];
         */
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 7, 2, 3, 6, 5, 4, 9, 8};
        for (int i = 0; i < bubbleSort(a).length; i++) {
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
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
        System.out.println();
        System.out.println(fib(3));
    }
}
