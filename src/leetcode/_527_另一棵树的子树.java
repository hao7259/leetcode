package leetcode;

public class _527_另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return dfs(root, subRoot);


    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);

    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        return (check(root.left, subRoot) && check(root.right, subRoot));

    }
}
