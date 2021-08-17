package JiangzhiOffer.DuplicationInArray;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    private static final int[] INTS = new int[]{6, 7, 1, 3, 2, 5, 3};

    /**
     * 排序后，遍历比较
     * @param ints
     * @return
     */
    private static int solution1(int[] ints) {
        if (ints == null || ints.length == 0) {
            return -1;
        }
        Arrays.sort(ints);
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] == ints[i + 1]) {
                return ints[i];
            }
        }
        return -1;
    }

    /**
     * 利用哈希表，遍历数组，如果哈希表中没有该元素，则存入哈希表中，否则返回重复的元素。时间复杂度为 O(n)，空间复杂度为 O(n)。
     * @param ints
     * @return
     */
    private static int solution2(int[] ints) {
        if (ints == null || ints.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < ints.length; i++) {
            if (hashMap.get(ints[i]) == null) {
                hashMap.put(ints[i], 1);
            } else if (hashMap.get(ints[i]) == 1) {
                return ints[i];
            }

        }
        return -1;
    }

    /**
     * 长度为 n，元素的数值范围也为 n，如果没有重复元素，那么数组每个下标对应的值与下标相等。
     * 从头到尾遍历数组，当扫描到下标 i 的数字 nums[i]：
     *
     * 如果等于 i，继续向下扫描；
     * 如果不等于 i，拿它与第 nums[i] 个数进行比较，如果相等，说明有重复值，返回 nums[i]。如果不相等，就把第 i 个数 和第 nums[i] 个数交换。重复这个比较交换的过程。
     * 此算法时间复杂度为 O(n)，因为每个元素最多只要两次交换，就能确定位置。空间复杂度为 O(1)。
     * @param ints
     * @return
     */
    private static int solution3(int[] ints) {
        if (ints == null || ints.length == 0) {
            return -1;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == ints[ints[i]]){
                return ints[i];
            }else {
                int tem = ints[i];
                ints[i] = ints[ints[i]];
                ints[ints[i]] = tem;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution1(INTS));
        System.out.println(solution2(INTS));
        System.out.println(solution3(INTS));
    }
}
