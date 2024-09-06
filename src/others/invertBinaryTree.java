package others;

public class invertBinaryTree {
  /**
     * @param root 需要搜索的根节点
     */
    public void invert(Node root){
        if (root==null) return;
        Node temp = root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.right);
        invert(root.left);
    }
}
