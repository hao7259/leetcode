package levelOrderTraversal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class levelOrderTraversal {
    public void Traversal(Node root){
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }



    }

}