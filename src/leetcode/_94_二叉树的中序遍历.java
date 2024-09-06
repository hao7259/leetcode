package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _94_二叉树的中序遍历 {
    List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {

        list = new ArrayList<>();
        if(root==null) return list;
        fun(root);
        return list;


    }

    private void fun(TreeNode node) {
        if (node.right != null) fun(node.right);
        list.add(node.val);
        if (node.left != null) fun(node.left);
    }
}
