package JiangzhiOffer.FindInPartiallySortedMatrix;

public class Solution {
    private static final int[][] INTS = new int[][]{{1,2,3},{2,3,4},{3,4,5}};

    /**
     * 从右上角开始查找
     * 1，若target小于该元素，则k--
     * 2，若target大于该元素，则j++
     * 3，如target等于该元素，则返回true
     * @param ints
     * @param target
     * @return
     */
    private static boolean solution(int[][] ints,int target){
        if (ints == null){
            return false;
        }
        int le = ints.length;
        int ro = ints[0].length;
        int j = 0;
        int k = ro -1;
        while (0<=j && j<= le-1 && 0<=k && k <= ro-1){
            if (target < ints[j][k]){
                k--;
            }else if (target > ints[j][k]){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 从左下角开始查找
     * 1、若target小于该元素，则j--
     * 2、若target大于该元素，则k++
     * 3、若相等，则返回true
     * @param ints
     * @param target
     * @return
     */
    private static boolean solution2(int[][] ints,int target){
        if (ints == null){
            return false;
        }
        int le = ints.length;
        int ro = ints[0].length;
        int j = le-1;
        int k = 0;
        while (0<=j&&j<=le-1 && 0<=k && k <= ro-1){
            if (target < ints[j][k]){
                j--;
            }else if (target > ints[j][k]){
                k++;
            }else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(solution(INTS,3));
        System.out.println(solution2(INTS,3));
    }
}
