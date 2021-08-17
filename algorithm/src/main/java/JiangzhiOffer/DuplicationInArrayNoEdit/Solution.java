package JiangzhiOffer.DuplicationInArrayNoEdit;

public class Solution {
    private static final int[] INTS = new int[]{1, 2, 3, 4, 1, 5};

    private static int solution(int[] ints) {
        if (ints == null || ints.length == 0) {
            return -1;
        }
        int[] tems = new int[6];
        for (int i = 0; i < ints.length; i++) {
            if (tems[ints[i]] != 0) {
                return ints[i];
            } else {
                tems[ints[i]] = 1;
            }
        }
        return -1;
    }

    private static int solution2(int[] ints){
        if (ints == null || ints.length < 1) {
            return -1;
        }

        int start = 1;
        int end = ints.length - 1;
        while (end >= start) {
            int middle = start + ((end - start) >> 1);

            // 调用 log n 次
            int count = countRange(ints, start, middle);
            if (start == end) {
                if (count > 1) {
                    return start;
                }
                break;
            } else {
                // 无法找出所有重复的数
                if (count > (middle - start) + 1) {
                    end = middle;
                } else {
                    start = middle + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 计算整个数组中有多少个数的取值在[start, end] 之间
     * 时间复杂度 O(n)
     * @param numbers 数组
     * @param start 左边界
     * @param end 右边界
     * @return 数量
     */
    private static int countRange(int[] numbers, int start, int end) {
        if (numbers == null) {
            return 0;
        }
        int count = 0;
        for(int e : numbers) {
            if (e >= start && e <= end) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(INTS));
        System.out.println(solution2(INTS));
    }
}
