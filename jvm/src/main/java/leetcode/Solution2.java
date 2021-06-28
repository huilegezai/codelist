package leetcode;

import JiangzhiOffer.PrintListInReversedOrder.ListNode;

import java.util.*;

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
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0, len = s.length();
        for (int j = 0; j < len; j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }

    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * <p>
     * 要求时间复杂度为O(n)。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
//        int max = nums[0];
//        for (int i=1;i<nums.length;i++){
//            if (max + nums[i] > nums[i]){
//                max += nums[i];
//            }else {
//                max = nums[i];
//            }
//        }
//        return max;
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum + num > num) {
                sum = sum + num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/99wd55/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5vokvr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
        /** 只使用一维数组解决
         * if(arr==null || arr.length==0)
         * 			return 0;
         *
         * 		int rows = arr.length;
         * 		int cols = arr[0].length;
         * 		int[] maxValue = new int[cols];
         * 		for(int i=0;i<rows;i++) {
         * 			for(int j=0;j<cols;j++) {
         * 				int left = 0;
         * 				int up = 0;
         * 				if(i>0)
         * 					up = maxValue[j];
         * 				if(j>0)
         * 					left = maxValue[j-1];
         * 				maxValue[j] = Math.max(up, left)+arr[i][j];
         *                        }* 		}
         * 		return maxValue[cols-1];
         */
    }

    public int maxProfit(int[] prices) {
        /*超时
        int max = 0;
        for (int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                int sum = prices[j] - prices[i];
                if (sum > max){
                    max = sum;
                }
            }
        }
        if (max <0){
            return 0;
        }
        return max;
         */
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     * <p>
     * <p>
     * <p>
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
     * 示例2:
     * <p>
     * 输入: 2
     * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
     * <p>
     * <p>
     * 限制：
     * <p>
     * 1 <= n <= 11
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/ozzl1r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {

    }

    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * 说明:
     * <p>
     * 1是丑数。
     * n不超过1690。
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9h3im5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入: n = 3
     * 输出:6
     * 示例 2：
     * <p>
     * 输入: n = 9
     * 输出:45
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9h44cj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        return (n + 1) * n / 2;
    }


    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * <p>
     * 示例1:
     * 输入: [1,2,3,4,5]
     * 输出: True
     * <p>
     * 示例2:
     * 输入: [0,0,1,2,5]
     * 输出: True
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/57mpoj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) { // 跳过大小王
                continue;
            }
            max = Math.max(max, num);// 最大牌
            min = Math.min(min, num);// 最小牌
            if (repeat.contains(num)) { // 若有重复，提前返回false
                return false;
            }
            repeat.add(num);// 添加此牌至 set
        }
        return max - min < 5;// 最大牌-最小牌 < 5 则可构成顺子
    }

    /**
     * 找出数组中重复的数字。
     * <p>
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/59bjss/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> repeat = new HashMap<>();
        for (int num : nums) {
            if (repeat.getOrDefault(num, -1) == 1) {
                return num;
            } else {
                repeat.put(num, 1);
            }
        }
        return -1;
        /**
         *    Set<Integer> dic = new HashSet<>();
         *         for(int num : nums) {
         *             if(dic.contains(num)) return num;
         *             dic.add(num);
         *         }
         *         return -1;
         *
         */
    }

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * 示例:
     * <p>
     * 现有矩阵 matrix 如下：
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target=5，返回true。
     * <p>
     * 给定target=20，返回false。
     * <p>
     * <p>
     * 限制：
     * <p>
     * 0 <= n <= 1000
     * <p>
     * 0 <= m <= 1000
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5v76yi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && 0 <= j) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：[2,2,2,0,1]
     * 输出：0
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50xofm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        /**
         *  int i = 0, j = numbers.length - 1;
         *         while (i < j) {
         *             int m = (i + j) / 2;
         *             if (numbers[m] > numbers[j]) i = m + 1;
         *             else if (numbers[m] < numbers[j]) j = m;
         *             else j--;
         *         }
         *         return numbers[i];
         *
         * 作者：Krahets
         * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5055b1/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                return numbers[i];
            }
        }
        return min;
    }

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * <p>
     * 示例:
     * <p>
     * s = "abaccdeff"
     * 返回 "b"
     * <p>
     * s = ""
     * 返回 " "
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5viisg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        /** 没法算出第一个只出现一次的字符，只能算出任意一个
         char[] chars = s.toCharArray();
         Map<Character,Integer> map = new HashMap<>();
         for (int i=0;i<chars.length;i++){
         if (map.getOrDefault(chars[i],-1) == -1){
         map.put(chars[i],1);
         }else {
         map.put(chars[i],map.get(chars[i])+1);
         }
         }
         for (Character c:map.keySet()){
         if (map.get(c) == 1){
         return c;
         }
         }
         return ' ';
         */
        /** 没法算出第一个只出现一次的字符，只能算出任意一个
         char[] chars = s.toCharArray();
         Arrays.sort(chars);
         for (int i = 0;i<chars.length-1;i++){
         if (chars[i] != chars[i+1]){
         return chars[i];
         }
         }
         return ' ';
         */
        /* 有解
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<chars.length;i++){
            if (map.getOrDefault(chars[i],-1) == -1){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        for (int i=0;i<chars.length;i++){
            if (map.get(chars[i]) == 1){
                return chars[i];
            }
        }
        return ' ';
         */
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue()) {
                return d.getKey();
            }
        }
        return ' ';
    }


    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * 示例2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     *
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5874p1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        /* 暴力解法，遍历数组
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] == target){
                sum += 1;
            }
        }
        return sum;
         */

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
