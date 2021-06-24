package leetcode;

import JiangzhiOffer.ConstructBinaryTree.TreeNode;
import JiangzhiOffer.PrintListInReversedOrder.ListNode;
import sun.font.TrueTypeFont;

import java.util.*;

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
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] % 10 != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        int length = 1;
        for (int i = 0; i < n; i++) {
            length *= 10;
        }
        int[] ints = new int[length - 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * <p>
     * 返回删除后的链表的头节点。
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode n = head;
        while (head != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                break;
            } else {
                head = head.next;
            }

        }
        return n;
    }

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        // 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
        // 1. 若目前堆的大小小于K，将当前数字放入堆中。
        // 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
        // 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器
        Queue<Integer> pq = new PriorityQueue<Integer>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        // 返回堆中元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);

    }

    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[0];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) {

            }
            while (--j >= lo && nums[j] > v) {

            }
            if (i > j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        //此题求拼接起来的最小数字，本质上是一个排序问题。设数组 numsnums 中任意两数字的字符串为 xx 和 yy ，则规定 排序判断规则 为：
        //若拼接字符串 x + y > y + xx+y>y+x ，则 xx “大于” yy；
        //反之，若 x + y < y + xx+y<y+x ，则 xx “小于” yy；
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }

    /**
     * 给你一个包含 n 个整数的数nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        return null;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int nu = 0;
        for (int num : nums) {
            nu = nu ^ num;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
//        return nu;
        return (int) set.toArray()[0];
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            if (hashMap.get(num) > length / 2) {
                return num;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int lo = matrix.length;
        int li = matrix[0].length;
        int i = 0;
        int k = matrix[0].length - 1;
        while (-1 < i && i < lo && -1 < k && k < li) {
            if (matrix[i][k] > target) {
                k--;
            } else if (matrix[i][k] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
     * <p>
     * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 示例 2：
     * <p>
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[index++] = nums1[i++];
            } else {
                temp[index++] = nums2[j++];
            }
        }
        for (; i < m; ) {
            temp[index++] = nums1[i++];
        }
        for (; j < n; ) {
            temp[index++] = nums2[j++];
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;
        while (j >= 0) {
            nums1[end--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        //这题没什么难度，最简单的就是使用双指针，一个指向前，一个指向后，遇到空格以及特殊字符要跳过，然后判断，画个图来看下
        if (s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //因为题中说了，只考虑字母和数字，所以不是字母和数字的先过滤掉
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            //然后把两个字符变为小写，在判断是否一样，如果不一样，直接返回false
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    /**
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    /**
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
     * <p>
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/introduction-to-data-structure-binary-search-tree/xp1llt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode curr = root;
        if (curr == null) {
            return newNode;
        }
        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = newNode;
                    return root;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = newNode;
                    return root;
                } else {
                    curr = curr.right;
                }
            }
        }
        /**
         * if (root == null) {
         *             return new TreeNode(val);
         *         }
         *
         *         if (val < root.val) {
         *             root.left = insertIntoBST(root.left, val);
         *         } else {
         *             root.right = insertIntoBST(root.right, val);
         *         }
         *         return root;
         */
    }

    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     * <p>
     * 一般来说，删除节点可分为两个步骤：
     * <p>
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/introduction-to-data-structure-binary-search-tree/xpcnds/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    /**
     * 从点(x, y)可以转换到(x, x+y) 或者(x+y, y)。
     * <p>
     * 给定一个起点(sx, sy)和一个终点(tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True，否则返回False。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reaching-points
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @return
     */
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) {
                break;
            }
            if (tx > ty) {
                if (ty > sy) {
                    tx %= ty;
                } else {
                    return (tx - sx) % ty == 0;
                }
            } else {
                if (tx > sx) {
                    ty %= tx;
                } else {
                    return (ty - sy) % tx == 0;
                }
            }
        }
        return (tx == sx && ty == sy);
    }

    public static Boolean isequals(int a, int b, int tx) {
        if (a == tx) {
            return true;
        } else if (a < tx) {
            int ta = a + b;
            if (isequals(ta, b, tx)) {
                return true;
            } else {
                return isequals(a, ta, tx);
            }
        } else {
            return false;
        }
    }

    /**
     * 给你一个字符串数组 words（下标 从 0 开始 计数）。
     * <p>
     * 在一步操作中，需先选出两个 不同 下标 i 和 j，其中 words[i] 是一个非空字符串，接着将 words[i] 中的 任一 字符移动到 words[j] 中的 任一 位置上。
     * <p>
     * 如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：words = ["abc","aabc","bc"]
     * 输出：true
     * 解释：将 words[1] 中的第一个 'a' 移动到 words[2] 的最前面。
     * 使 words[1] = "abc" 且 words[2] = "abc" 。
     * 所有字符串都等于 "abc" ，所以返回 true 。
     * 示例 2：
     * <p>
     * 输入：words = ["ab","a"]
     * 输出：false
     * 解释：执行操作无法使所有字符串都相等。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 100
     * words[i] 由小写英文字母组成
     *
     * @param words
     * @return
     */
    public boolean makeEqual(String[] words) {
        /**
         * 这道题表面上是挪动字符使得数组中每个字符都相等，其实我们不难发现，字符串相等就是原数组中每个字符出现的数量都得是数组长度的整数倍，
         * 这样我们就可以将全部字符平均分给数组中的各个字符串，所以挪动任意字符判断数组中所有字符是否相等的问题就可以转化为求数组中各个字符出现的频率问题了
         */
        Map<Character, Integer> letter = new HashMap<Character, Integer>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (letter.get(words[i].charAt(j)) == null) {
                    letter.put(words[j].charAt(j), 1);
                } else {
                    letter.put(words[i].charAt(j), letter.get(words[i].charAt(j)) + 1);
                }
            }

        }
        for (Integer in : letter.values()) {
            if (in % words.length != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
     * <p>
     * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
     * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
     * 重复步骤 2 ，直到你没法从 s 中选择字符。
     * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
     * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
     * 重复步骤 5 ，直到你没法从 s 中选择字符。
     * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
     * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
     * <p>
     * 请你返回将 s 中字符重新排序后的 结果字符串 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aaaabbbbcccc"
     * 输出："abccbaabccba"
     * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
     * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
     * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
     * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
     * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
     * 示例 2：
     * <p>
     * 输入：s = "rat"
     * 输出："art"
     * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
     * 示例 3：
     * <p>
     * 输入：s = "leetcode"
     * 输出："cdelotee"
     * 示例 4：
     * <p>
     * 输入：s = "ggggggg"
     * 输出："ggggggg"
     * 示例 5：
     * <p>
     * 输入：s = "spo"
     * 输出："ops"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 500
     * s 只包含小写英文字母。
     *
     * @param s
     * @return
     */
    public String sortString(String s) {
        return null;
    }

    /**
     * 给你一个二进制字符串 s ，现需要将其转化为一个 交替字符串 。请你计算并返回转化所需的 最小 字符交换次数，如果无法完成转化，返回 -1 。
     * <p>
     * 交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010" 属于交替字符串，但 "0100" 不是。
     * <p>
     * 任意两个字符都可以进行交换，不必相邻 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "111000"
     * 输出：1
     * 解释：交换位置 1 和 4："111000" -> "101010" ，字符串变为交替字符串。
     * 示例 2：
     * <p>
     * 输入：s = "010"
     * 输出：0
     * 解释：字符串已经是交替字符串了，不需要交换。
     * 示例 3：
     * <p>
     * 输入：s = "1110"
     * 输出：-1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 1000
     * s[i] 的值为 '0' 或 '1'
     *
     * @param s
     * @return
     */
    public int minSwaps(String s) {
        return 0;
    }


    /**
     * 给定一个二叉树，找出其最小深度。
     * <p>
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * <p>
     * 说明：叶子节点是指没有子节点的节点。
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // null节点不参与比较
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * 给定一个非负整数numRows，生成杨辉三角的前numRows行。
     * <p>
     * <p>
     * <p>
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例:
     * <p>
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3, 3,1],
     * [1,4,6,4,1]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pascals-triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arrayList = new ArrayList();
        for (int i = 0; i < numRows; ++i ){
            List<Integer> a = new ArrayList<>();
            for (int j = 0;j <= i;++j){
                if (j==0 || i == j){
                    a.add(1);
                }else {
                    a.add(arrayList.get(i - 1).get(j - 1) + arrayList.get(i - 1).get(j));
                }
            }
            arrayList.add(a);
        }
        return arrayList;
    }

    /**
     * 119. 杨辉三角 II
     * 给定一个非负索引k，其中 k≤33，返回杨辉三角的第 k 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * 示例:
     * 输入: 3
     * 输出: [1,3,3,1]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        /* 使用上个方法generate
        List<List<Integer>> arrayList = new ArrayList();
        for (int i = 0; i <= rowIndex; ++i ){
            List<Integer> a = new ArrayList<>();
            for (int j = 0;j <= i;++j){
                if (j==0 || i == j){
                    a.add(1);
                }else {
                    a.add(arrayList.get(i - 1).get(j - 1) + arrayList.get(i - 1).get(j));
                }
            }
            arrayList.add(a);
        }
        return arrayList.get(rowIndex);
         */

        // 注意到对第 i+1i+1 行的计算仅用到了第 ii 行的数据，因此可以使用滚动数组的思想优化空间复杂度。
        List<Integer> pre = new ArrayList<>();
        for (int i=0;i<= rowIndex;i++){
            List<Integer> cur = new ArrayList<>();
            for (int j=0;j<=i;j++){
                if (j==0||j==i){
                    cur.add(1);
                }else {
                    cur.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;

    }

    /**
     * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
     * 叶子节点 是指没有子节点的节点。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || root.val > targetSum){
            return false;
        } else if (root.val == targetSum){
            return true;
        } else {
            return pathSum(root.right, root.val, targetSum) || pathSum(root.left, root.val, targetSum);
        }
    }

    public static boolean pathSum(TreeNode root,int sum,int targetSum){
        if (root == null){
            return false;
        }
        if (root.val + sum == targetSum){
            return true;
        }else if (root.val + sum > targetSum){
            return false;
        }else {
            if (root.left != null && root.right == null) {
                return pathSum(root.left, root.val + sum, targetSum);
            }
            if (root.right != null && root.left == null) {
                return pathSum(root.right, root.val + sum, targetSum);
            }
            if (root.left != null && root.right != null) {
                return pathSum(root.right, root.val + sum, targetSum) || pathSum(root.left, root.val + sum, targetSum);
            }
            return false;
        }
    }

    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return targetSum - root.val == 0;
        }
        return hasPathSum1(root.left,targetSum - root.val) || hasPathSum1(root.right,targetSum - root.val);
    }

    /**
     * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     *
     * 示例 2：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
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
        if (prices.length <= 1){
            return 0;
        }
        int min = prices[0],max = 0;
        for (int i = 0;i<prices.length;i++){
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }

    /**
     * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *
     *
     * 示例 1:
     *
     * 输入: prices = [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     *
     * 输入: prices = [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例3:
     *
     * 输入: prices = [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     *
     * 提示：
     *
     * 1 <= prices.length <= 3 * 104
     * 0 <= prices[i] <= 104
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int min = prices[0],max = 0;
        int sum = 0;
        for (int i = 0;i<prices.length;i++){
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
            if (max > 0){
                sum += max;
                max = 0;
                min = prices[i];
            }
        }
        return Math.max(max,sum);
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

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
        System.out.println(singleNumber(new int[]{-2, -2, 1, -3, -1, -3, 1, 4, 4}));
        System.out.println(majorityElement(new int[]{-2, -2, -2, -2, -2, -2, 1, 4, 4}));
        System.out.println(isPalindrome("qwwq"));
        System.out.println(reachingPoints(1, 1, 3, 5));
    }
}
