package JiangzhiOffer.FindInPartiallySortedMatrix;

public class Solution {
    private static final int[][] INTS = new int[][]{{1,2,3},{2,3,4},{3,4,5}};

    private static boolean solution(int[][] ints,int target){
        if (ints == null){
            return false;
        }
        int le = ints.length;
        int ro = ints[0].length;
        int j=le;
        int k = ro;
        while (j >= 0 && k >=0 && le >= j-1 && ro >= k-1 ){
            if (ints[j][k] > target){
                k--;
            }else if (ints[j][k] < target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(solution(INTS,9));
    }
}
