package leetcode;

public class _527_另一棵树的子树2 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null||root.val != subRoot.val ) {
            return false;
        }
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);

    }
}
