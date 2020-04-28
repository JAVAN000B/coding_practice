/**
 * @Classname BinaryTreeDepth
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class BinaryTreeDepth {
    static class treeNode{
        int data;
        treeNode left;
        treeNode right;
        treeNode(int data){
            this.data = data;
        }
    }
    public int findDepth(treeNode root) {
        if (root == null) return 0;
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        return left>right ? left+1 : right+1;
    }

}
