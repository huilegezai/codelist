package JiangzhiOffer.ConstructBinaryTree;

public class Solution {
    private static TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        if (pre == null || in == null || pre.length!=in.length){
            return null;
        }
        int n = pre.length;
        return constructBinaryTree(pre,0,n-1,in,0,n-1);
    }
    private static TreeNode constructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        TreeNode node = new TreeNode(pre[startPre]);
        if (startPre == endPre){
            if (startIn == endIn){
                return node;
            }
            throw new IllegalArgumentException("Invalid input");
        }
        int inOrder = startIn;
        while (in[inOrder] != pre[startPre]){
            ++inOrder;
            if (inOrder > endIn){
                new IllegalArgumentException("Invalid input");
            }
        }
        int len = inOrder - startIn;
        if (len > 0){
            // 递归构建左子树
            node.left = constructBinaryTree(pre,startPre + 1,startPre + len,in,startIn,inOrder -1);
        }
        if (inOrder < endIn){
            // 递归构建右子树
            node.right = constructBinaryTree(pre, startPre + len + 1, endPre, in, inOrder + 1, endIn);
        }

        return node;
    }

    public static void main(String[] args) {
        System.out.println(reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6}).val);
    }
}
