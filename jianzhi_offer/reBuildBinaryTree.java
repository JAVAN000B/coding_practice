import java.util.Arrays;

/**
 * @Classname reBuildBinaryTree
 * @Description TODO
 * @Author Minghui Sun, Fengjie Gu
 * @Version 1.0
 */
public class reBuildBinaryTree {
    class TreeNode{
        Integer data;
        TreeNode left;
        TreeNode right;
        public TreeNode(Integer data){
            this.data = data;
        }
        //重写toString方法       （感觉会加分？） 并不
        public String toString() {
            return "TreeNode [data=" + data + ", left=" + left + ", right=" + right
                    + "]";
        }
    }

    public reBuildBinaryTree(){

    }

    //pre order and in order
    public TreeNode rebuild(int[] preOrder, int[] inOrder){
        if (preOrder == null || inOrder == null) {
            return null;
        }
        if (preOrder.length == 0) {
            return null;
        }
        TreeNode root = null;
        for (int i = 0; i < inOrder.length; ++i) {
            if (inOrder[i]==preOrder[0]){
                root = new TreeNode(preOrder[0]);
                root.left = rebuild(Arrays.copyOfRange(preOrder,1,i+1),Arrays.copyOfRange(inOrder,0,i));
                root.right = rebuild(Arrays.copyOfRange(preOrder, i+1,preOrder.length),Arrays.copyOfRange(inOrder, i+1,inOrder.length));
            }
        }
        return root;
    }

    //in order and post order
    public TreeNode rebuild2(int[] postOrder, int[] inOrder) {
        if (postOrder == null || inOrder == null) {
            return null;
        }
        if (postOrder.length == 0) {
            return null;
        }
        TreeNode root = null;
        for (int i = 0; i < inOrder.length; ++i) {
            if (inOrder[i]==postOrder[postOrder.length - 1]){
                root = new TreeNode(inOrder[i]);
                root.left = rebuild2(Arrays.copyOfRange(postOrder,0,i),Arrays.copyOfRange(inOrder,0,i));
                root.right = rebuild2(Arrays.copyOfRange(postOrder,i,postOrder.length-1),Arrays.copyOfRange(inOrder, i+1,inOrder.length));
            }
        }


        return root;
    }

    public static void main(String[] args) {
        reBuildBinaryTree machine = new reBuildBinaryTree();
        TreeNode root = machine.rebuild(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
        TreeNode root2 = machine.rebuild2(new int[]{7,4,2,5,8,6,3,1}, new int[]{4,7,2,1,5,3,8,6});
        System.out.println("finish");
    }
}
