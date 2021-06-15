package leetcode;

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

    private static String isWin(){
        int homeScore = 6;
        int awayScore = 10;
        if ( homeScore - 2.5 > awayScore) {
          return "Home -2.5";
        }
        if ( homeScore + 2.5 > awayScore) {
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
    }
}
