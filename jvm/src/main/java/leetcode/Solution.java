package leetcode;

import JiangzhiOffer.PrintListInReversedOrder.ListNode;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
//        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
//            s = s.replace("()", "");
//            s = s.replace("{}", "");
//            s = s.replace("[]", "");
//        }
//        if ("".equals(s)) {
//            return false;
//        }
//        return true;

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    /**
     * 给你一个数组nums和一个值val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static int removeElement1(int[] nums, int val) {
        int ans = nums.length;
        for (int i = 0; i < ans; ) {
            if (nums[i] == val) {
                nums[i] = nums[ans - 1];
                ans--;
            } else {
                i++;
            }
        }
        return ans;
    }

    /**
     * 给你两个字符haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        //    char[] main = haystack.toCharArray(), from = needle.toCharArray();
        // 	for (int i = 0; i <= main.length - from.length; i++) {
        // 		int j;
        // 		for (j = 0; j < from.length; j++)
        // 			if (main[i + j] != from[j])
        // 				break;
        // 		if (j == from.length)
        // 			return i;
        // 	}
        // 	return -1;
        if (needle == null || needle == "" || haystack == null || haystack == "") {
            return 0;
        }
        int hleng = haystack.length();
        int nleng = needle.length();
        if (hleng < nleng) {
            return -1;
        }
        for (int i = 0; i < hleng - nleng; i++) {
            for (int j = 0; j < nleng; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == nleng - 1 && haystack.charAt(i + j) == needle.charAt(j)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
//        int i;
//        for ( i = 0;i< nums.length;i++){
//            if (nums[i] >= target){
//                return i;
//            }
//        }
//        return i;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return target;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static String isWin() {
        int homeScore = 6;
        int awayScore = 10;
        if (homeScore - 2.5 > awayScore) {
            return "Home -2.5";
        }
        if (homeScore + 2.5 > awayScore) {
            return "Home +2.5";
        }
        if (awayScore - 2.5 > homeScore) {
            return "Away -2.5";
        }
        if (awayScore + 2.5 > homeScore) {
            return "Away +2.5";
        }
        return "false";
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
//        int res = nums[0];
//        int sum = 0;
//        for (int num:nums){
//            if (sum + num > num){
//                sum = sum + num;
//            }else {
//                sum = num;
//            }
//            res = Math.max(res,sum);
//        }
//        return res;
        // Kadane算法扫描一次整个数列的所有数值，
        // 在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
        // 该子数列由两部分组成：以前一个位置为结束点的最大子数列、该位置的数值。
        // 因为该算法用到了“最佳子结构”（以每个位置为终点的最大子数列都是基于其前一位置的最大子数列计算得出,
        // 该算法可看成动态规划的一个例子。
        // 状态转移方程：sum[i] = max{sum[i-1]+a[i],a[i]}
        // 其中(sum[i]记录以a[i]为子序列末端的最大序子列连续和)
        int max_ending_here = nums[0];
        int max_so_far = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 以每个位置为终点的最大子数列 都是基于其前一位置的最大子数列计算得出,
            max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    /**
     * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
     * <p>
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
//        if (" ".equals(s)){
//            return 0;
//        }
//        if (!s.contains(" ")){
//            return s.length();
//        }
//        int le = 0;
//        for (int i=0;i<s.length();i++){
//            if (s.charAt(i) == ' '){
//                le = i;
//            }
//        }
//        if (le == s.length()){
//            return s.length();
//        }
//        return s.length() -1 - le;
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (length != 0 && s.charAt(i) == ' ') {
                break;
            } else if (s.charAt(i) == ' ') {
            } else {
                length++;
            }
        }
        return length;
    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public static  int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]%10!=0){
                return digits;
            }
        }
        digits= new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr.next != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        int length = 1;
        for (int i =0;i<n;i++){
            length *= 10;
        }
        int[] ints = new int[length-1];
        for (int i=0;i< ints.length;i++){
            ints[i] = i +1 ;
        }
        return ints;
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     *
     * 返回删除后的链表的头节点。
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val){
            return head.next;
        }
        ListNode n = head;
        while (head !=null){
            if (head.next.val == val){
                head.next = head.next.next;
                break;
            }else {
                head = head.next;
            }

        }
        return n;
    }

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i =0;i<k;i++){
            res[i] = arr[i];
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(isValid("{}[]()"));
        System.out.println(removeDuplicates(new int[]{1, 2, 3, 4, 4, 5, 6, 6, 7}));
        int[] ints = new int[]{1, 2, 3, 4, 4, 5, 6, 6, 7};
        int size = removeElement1(ints, 6);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.print(ints[i]);
        }
        System.out.println();
        System.out.println(strStr("", ""));
//        System.out.println(searchInsert(new int[]{1, 2, 3, 4, 4, 5, 6, 6, 7}, 0));
        System.out.println(isWin());
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(lengthOfLastWord("iii ssss lllle"));
        System.out.println(lengthOfLastWord("         "));
        System.out.println(lengthOfLastWord("iii "));
        System.out.println(lengthOfLastWord("iiir"));
    }
}
