
/**
 * @Classname nextInorderNode
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class nextInorderNode {
    static class TreeNode<T> {
        T data;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        public TreeNode(T data){
            this.data = data;
        }
    }

    public nextInorderNode(){
    }

    public TreeNode findNext(TreeNode node) {
        if (node.right!=null){
            node = node.right;
            while (node.left!=null){
                node = node.left;
            }
            return node;
        } else {
            if (node.parent.left == node){
                return node.parent;
            } else {
                while (node.parent != node.parent.parent.left){
                    node = node.parent;
                }
                return node;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[10];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i);
        }
        for(int i = 0; i < 10; i++)
        {
            if(i*2+1 < 10){
                nodes[i].left = nodes[i*2+1];
                nodes[i].left.parent = nodes[i];
            }
            if(i*2+2 < 10){
                nodes[i].right = nodes[i*2+2];
                nodes[i].right.parent = nodes[i];
            }
        }
    }

}
