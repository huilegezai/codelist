package leetcode;

import java.util.*;

/**
 * 初级算法
 */
public class Chujisuanfa {
    /**
     *给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     *
     *
     * 说明:
     *
     * 为什么返回数值是整数，但输出的答案是数组呢?
     *
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *  print(nums[i]);
     * }
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     *
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按升序排列
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 边界条件
        if (nums == null || nums.length==0){
            return 0;
        }
        int left = 0;
        for (int right =0;right<nums.length;right++){
            //如果左指针和右指针指向的值一样，说明有重复的
            //这个时候，左指针不动，右指针继续往右移
            //如果他两指向的值不一样就把右指针的值往前挪
            if (nums[left] != nums[right]){
                nums[++left] = nums[right];
            }
        }
        return ++left;
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
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
            if (max > 0) {
                sum += max;
                max = 0;
                min = prices[i];
            }
        }
        return Math.max(max, sum);
    }

    /**
     * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
     *
     *
     *
     * 进阶：
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例2:
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 2 * 104
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [1,2,3,1]
     * 输出: true
     * 示例 2:
     *
     * 输入: [1,2,3,4]
     * 输出: false
     * 示例3:
     *
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     *
     * 输入: [2,2,1]
     * 输出: 1
     * 示例2:
     *
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum ^= nums[i];
        }
        return sum;
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *
     *
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果nums1的大小比nums2小很多，哪种方法更优？
     * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length ==0 || nums2 == null || nums2.length ==0){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int j=0;j<nums2.length;j++){
            map.put(nums2[j],map.getOrDefault(nums2[j],0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums1.length;i++){
            if (map.getOrDefault(nums1[i],0) > 0 ){
                list.add(nums1[i]);
                map.put(nums1[i],map.get(nums1[i])-1);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int k = 0; k < list.size(); k++) {
            res[index++] = list.get(k);
        }
        return res;
    }
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> list = new ArrayList<>();
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i] < nums2[j]){
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[list.size()];
        int index = 0;
        for (int k = 0; k < list.size(); k++) {
            res[index++] = list.get(k);
        }
        return res;
    }
    public static void main(String[] args){
        intersect(new int[]{1,2,3,4},new int[]{2,3,4});
    }
}